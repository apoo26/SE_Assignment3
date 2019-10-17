import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Scanner;

class Vals<T> {
	public int maxSize;
	public T[] arr;
	public boolean phase = true;

	@SuppressWarnings("unchecked")
	public Vals(Class<T> cl, int size) {
		arr = (T[]) Array.newInstance(cl, size);
		maxSize = size;
	}

}

interface Prioritizer<T> {
	public void insert(T t);

	public void removeNextInOrder();

	public void removeAny();

	int compareTo(Object o);

	public void changePhase();

	public int size();

	public void check();
}

class J1<T> extends Vals<T> implements Prioritizer<T>, Comparator<T> {
	T[] arr1;

	public @SuppressWarnings("unchecked") J1(Class<T> cl, int size) {
		super(cl, size);
		arr1 = (T[]) Array.newInstance(cl, size);
	}

	int index = -1;
	int index1 = -1;

	public void insert(T a) {
		check();
		if (index < maxSize)
			;
		{
			arr[++index] = a;
			arr1[++index1] = a;
		}
	}

	public void removeNextInOrder() {
		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else

		{
			System.out.println("In Removal Phase in order");
			T x = arr1[0];
			for (int i = 0; i < index; i++) {
				arr1[i] = arr1[i + 1];
			}
			for (int i = 0; i < index; i++) {
				if (x == arr[i]) {
					for (int j = i; j < index; j++) {
						arr[j] = arr[j + 1];
					}
				}
			}
			--index;
			--index1;
			System.out.println(x);
		}

	}

	public void removeAny() {
		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else {
			System.out.println("In Removal Phase of any order");
			int z = (int) ((Math.random() * ((index - 0) + 1)) + 0);
			T x = arr[z];
			for (int i = z; i < index; i++) {
				arr[i] = arr[i + 1];
			}
			for (int i = 0; i < index; i++) {
				if (x == arr1[i]) {
					for (int j = 0; j < index; j++) {
						arr1[j] = arr1[j + 1];
					}
				}
			}
			index--;
			index1--;
			System.out.println(x);
		}
	}

	public void changePhase() {
		if (phase == true) {
			phase = false;
			sort(arr1);
		}
	}

	public void display() {
		for (int i = 0; i <= index; i++) {
			System.out.println(arr[i]);
		}
	}

	public int size() {
				return index + 1;
	}

	public void check() {
		if (phase == true) {
			System.out.println("In insertionphase");
		} else {
			phase = true;
			System.out.println(" phase changed to insertionphase");
		}
	}

	@Override
	public int compare(T o1, T o2) {
		Class c = o1.getClass();
		if (c.equals(Integer.class)) {
			int obj1 = (int) o1;
			int obj2 = (int) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else if (c.equals(Double.class)) {
			Double obj1 = (Double) o1;
			Double obj2 = (Double) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else {
			String obj1 = o1.toString();
			String obj2 = o2.toString();
			return obj1.compareTo(obj2);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sort(T a[]) {
		for (int i = 0; i <= index; i++) {
			for (int j = i + 1; j <= index; j++) {
				if (compare(a[i], a[j]) > 0) {
					T temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

}

class J2<T> extends Vals<T> implements Prioritizer<T>, Comparator<T> {
	// CONSTRUCTOR
	public J2(Class<T> cl, int size) {
		super(cl, size);
	}

	int index = -1;

	public void insert(T a) {
		check();
		if (index < maxSize) {
			arr[++index] = a;
			sort(arr);
		}
	}

	public void removeNextInOrder() {

		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else {
			System.out.println("In Removal Phase in order");
			T x = arr[0];
			for (int i = 0; i < index; i++) {
				arr[i] = arr[i + 1];
			}
			index--;
			System.out.println(x);
		}
	}

	public void removeAny() {
		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else {
			System.out.println("In Removal Phase of any order");
			int z = (int) ((Math.random() * ((index - 0) + 1)) + 0);
			T x = arr[z];
			for (int i = z; i < index; i++) {
				arr[i] = arr[i + 1];
			}
			index--;
			System.out.println(x);

		}
	}

	public void changePhase() {
		if (phase == true) {
			phase = false;
		}
	}

	public void display() {
		for (int i = 0; i <= index; i++) {
			System.out.println(arr[i]);
		}
	}

	public int size() {
		return index + 1;
	}

	public void check() {
		if (phase == true) {
			System.out.println("In insertionphase");
		} else {
			phase = true;
			System.out.println(" phase changed to insertionphase");
		}
	}

	@Override
	public int compare(T o1, T o2) {
		Class c = o1.getClass();
		if (c.equals(Integer.class)) {
			int obj1 = (int) o1;
			int obj2 = (int) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else if (c.equals(Double.class)) {
			Double obj1 = (Double) o1;
			Double obj2 = (Double) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else {
			String obj1 = o1.toString();
			String obj2 = o2.toString();
			return obj1.compareTo(obj2);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sort(T a[]) {
		for (int i = 0; i <= index; i++) {
			for (int j = i + 1; j <= index; j++) {
				if (compare(a[i], a[j]) > 0) {
					T temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}

class J3<T> extends Vals<T> implements Prioritizer<T>, Comparator<T> {
	T[] arr1;

	// CONSTRUCTOR
	public J3(Class<T> cl, int size) {
		super(cl, size);
		arr1 = (T[]) Array.newInstance(cl, size);
	}

	int index = -1;
	int index1 = -1;

	public void insert(T a) {
		check();
		if (index < maxSize) {
			arr[++index] = a;
			arr1[++index1] = a;
		}
	}

	public void removeNextInOrder() {
		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else {
			sort(arr1);
			System.out.println("In Removal Phase in order");
			T x = arr1[0];
			for (int i = 0; i < index; i++) {
				arr1[i] = arr1[i + 1];
			}
			for (int i = 0; i < index; i++) {
				if (x == arr[i]) {
					T y = arr[i];
					for (int j = i; j < index; j++) {
						arr[j] = arr[j + 1];
					}
				}
			}
			index--;
			index1--;
			System.out.println(x);
		}

	}

	public void removeAny() {
		changePhase();
		if (index == -1) {
			System.out.println("no element to remove!!");
		} else {
			System.out.println("In Removal Phase of any order");
			int z = (int) ((Math.random() * ((index - 0) + 1)) + 0);
			T x = arr[z];
			for (int i = z; i < index; i++) {
				arr[i] = arr[i + 1];
			}
			for (int i = z; i < index; i++) {
				arr[i] = arr[i + 1];
			}
			for (int i = 0; i < index; i++) {
				if (x == arr1[i]) {
					for (int j = 0; j < index; j++) {
						arr1[j] = arr1[j + 1];
					}
				}
			}
			index--;
			index1--;
			System.out.println(x);
		}
	}

	public void changePhase() {
		if (phase == true) {
			phase = false;
		}
	}

	public void display() {
		for (int i = 0; i <= index; i++) {
			System.out.println(arr[i]);
		}
	}

	public int size() {
		return index + 1;
	}

	public void check() {
		if (phase == true) {
			System.out.println("In insertionphase");
		} else {
			phase = true;
			System.out.println(" phase changed to insertionphase");
		}
	}

	@Override
	public int compare(T o1, T o2) {
		Class c = o1.getClass();
		if (c.equals(Integer.class)) {
			int obj1 = (int) o1;
			int obj2 = (int) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else if (c.equals(Double.class)) {
			Double obj1 = (Double) o1;
			Double obj2 = (Double) o2;

			if (obj1 > obj2)
				return 1;
			else if (obj1 == obj2)
				return 0;
			else
				return -1;
		} else {
			String obj1 = o1.toString();
			String obj2 = o2.toString();
			return obj1.compareTo(obj2);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sort(T a[]) {
		for (int i = 0; i <= index; i++) {
			for (int j = i + 1; j <= index; j++) {
				if (compare(a[i], a[j]) > 0) {
					T temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}

/*
 * CONTRIBUTIONS APOORVA: 1)RAKSHIT: He wrote the J1 class,i.e. prioritizer2 and
 * wrote a section of code of main class(TestClass). He initiated 3
 * conversations 2) ARADHANA: She wrote the J3 class,i.e. prioritizer 3 and
 * tested the integrated code. She initiated 2 conversations
 * 
 * RAKSHIT: 1)ARADHANA: The integrated code was tested by her and she
 * contributed the Prioritizer3 class. 2 conversations were started by her.
 * 2)APOORVA: She performed integration of code and implemented Prioritizer1.
 * She initiated 3 conversations.
 * 
 * ARADHANA: 1)APOORVA: She developed the code for prioritizer 1 and a part of
 * mainclass(TestClass). 3 conversations were initiated by her. 2)RAKSHIT: He
 * helped in integration of the code and Prioritiser2 was developed by him. He
 * initiated 3 conversations.
 */
public class TestClass<T> {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Select a prioritizer");
		int c = sc.nextInt();
		J1 p1 = new J1(Object.class, 30);
		J2 p2 = new J2(Object.class, 30);
		J3 p3 = new J3(Object.class, 30);
		char ch = 'y';
		Object s;
		while (ch == 'y') {
			if (c == 1) {

				System.out.println("Enter an option:" + "\n" + "1. Insert" + "\n" + "2.Delete in order" + "\n"
						+ "3. Delete in any order" + "\n" + "4.Check size");
				int x = sc.nextInt();
				if (x == 1) {
					System.out.println("Enter value to insert");
					s = reader.readLine();
					p1.insert(s);
				}
				if (x == 2) {
					p1.removeNextInOrder();
				}
				if (x == 3) {
					p1.removeAny();
				}
				if (x == 4) {
					System.out.println(p1.size());

				}
				System.out.println("Do you want to continue[y/n]:");
				ch = sc.next().charAt(0);
			} else if (c == 2) {

				System.out.println("Enter an option:" + "\n" + "1. Insert" + "\n" + "2.Delete in order" + "\n"
						+ "3. Delete in any order" + "\n" + "4.Check size");
				int x = sc.nextInt();
				if (x == 1) {
					System.out.println("Enter value to insert");
					s = reader.readLine();
					p2.insert(s);
				}
				if (x == 2) {

					p2.removeNextInOrder();
				}
				if (x == 3) {

					p2.removeAny();
				}
				if (x == 4) {
					System.out.println(p2.size());

				}
				System.out.println("Do you want to continue[y/n]:");
				ch = sc.next().charAt(0);
			} else {

				System.out.println("Enter an option:" + "\n" + "1. Insert" + "\n" + "2.Delete in order" + "\n"
						+ "3. Delete in any order" + "\n" + "4.Check size");
				int x = sc.nextInt();
				if (x == 1) {
					System.out.println("Enter value to insert");
					s = reader.readLine();
					p3.insert(s);
					p3.display();
				}
				if (x == 2) {

					p3.removeNextInOrder();
				}
				if (x == 3) {

					p3.removeAny();
				}
				if (x == 4) {
					System.out.println(p3.size());

				}
				System.out.println("Do you want to continue[y/n]:");
				ch = sc.next().charAt(0);
			}
		}

	}
}
