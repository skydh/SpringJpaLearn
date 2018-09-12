package pub;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dh.jpatest.test.UserAggVO;

public class DataConvert<T> {

	/**
	 * 考虑到数据量级不会很大，大多会分页，因此，3重循环效率可以接受
	 * 
	 * @param list
	 * @param cla
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public List<T> changeData(List<Object> list, Class<?> cla) throws  Exception {
		/**
		 * 根据sort对其排序
		 */
		Field[] fields = cla.getDeclaredFields();
		ArrayList<Field> arrayList = new ArrayList<Field>(fields.length);
		Collections.addAll(arrayList, fields);

		Collections.sort(arrayList, new Comparator<Field>() {
			public int compare(Field o1, Field o2) {
				sort sort1 = o1.getAnnotation(sort.class);
				int sorti1 = Integer.parseInt(sort1.value());
				sort sort2 = o2.getAnnotation(sort.class);
				int sorti2 = Integer.parseInt(sort2.value());
				if (sorti1 > sorti2) {
					return 1;
				}
				return -1;
			}
		});

		List<T> listData = new ArrayList<T>();
		T a = null;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);

			
				a = (T) cla.newInstance();
				for (int j = 0; j < obj.length; j++) {
					arrayList.get(j).setAccessible(true);
					arrayList.get(j).set(a, obj[j]);
				}
			

			listData.add(a);
		}

		return listData;

	}

}
