
//Prioritizer 2


import java.lang.reflect.Array;
import java.util.Comparator;

class Vals<T>
{
	public int maxSize = 10;
	public T[] arr;
	public boolean phase = true;

	@SuppressWarnings("unchecked")
	//CONSTRUCTOR
	public Vals(Class<T> cl, int size)
	{
		arr = (T[]) Array.newInstance(cl, size);
		maxSize = size;
	}

}

interface Prioritizer<T> 
{
	public void insert(T t);
	public void changePhase();
	public T removeNextInOrder();
	public T removeAny();
	int compareTo(Object o);
	public int size();
	public void check();
}

public class J1<T> extends Vals<T> implements Prioritizer<T>, Comparator<T> 
{
	//CONSTRUCTOR
	public J1(Class<T> cl, int size)
	{
		super(cl, size);
	}
	
	int index = -1;
	int index1 = -1;

	public void insert(T a)
	{
		check();
		if (index < maxSize)
		{
			arr[++index] = a;
			System.out.println("inserted element:"+arr[index]+"\n");
			sort(arr);
		}
	}
	

	public T removeNextInOrder() 
	{
		changePhase();
		System.out.println("In Removal Phase removing the next element in order");
		T x=arr[0];
		for(int i=0;i<index;i++) {
			arr[i]=arr[i+1];
		}
		index--;
		System.out.println(x+"\n");
		return x;
	}
	
	public T removeAny()
	{
		changePhase();
		System.out.println("In Removal Phase of any order");
		int z = (int) ((Math.random() * ((index - 0) + 1)) + 0);
		T x = arr[z];
		for (int i = z; i < index; i++) {
			arr[i] = arr[i + 1];
		}
		index--;
		System.out.println(x+"\n");
		return x;
	}

	public void changePhase()
	{
		if (phase == true)
		{
			phase = false;
		}
	}


	public int size() 
	{
		return index+1;
	}

	public void check() 
	{
		if (phase == true) 
		{
			System.out.println("In insertionphase");
		}
		else 
		{
			phase=true;
			System.out.println(" phase changed to insertionphase");
		}
	}


	@Override
	public int compare(T o1, T o2)
	{
		Class c=o1.getClass();
		if(c.equals(Integer.class))
		{
			int obj1=(int)o1;
			int obj2=(int)o2;

			if(obj1>obj2)
				return 1;
			else if(obj1==obj2)
				return 0;
			else
				return -1;
		}
		else if(c.equals(Double.class))
		{
			Double obj1=(Double)o1;
			Double obj2=(Double)o2;

			if(obj1>obj2)
				return 1;
			else if(obj1==obj2)
				return 0;
			else
				return -1;
		}
		else
		{
			String obj1=o1.toString();
			String obj2=o2.toString();
			return obj1.compareTo(obj2);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void sort(T a[]) 
	{
		for (int i = 0; i <= index; i++) 
		{
			for (int j = i + 1; j <= index; j++) 
			{
				if (compare(a[i], a[j])>0) 
				{
					T temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	

	public void display() 
	{
		for (int i = 0; i <= index; i++) 
		{
			System.out.println(arr[i]);
		}
	}



	public static void main(String[] args)
	{
		J1 p = new J1(Object.class, 10);
		p.insert("Hi I'm rakshit");
		p.insert("This is aradhna");
		p.insert("We both are team mates");
		p.insert("Apoorva is also our team mate");
		p.insert("Se is a very vast subject");
		p.insert("We have an appointment tommorow with meghan");
		p.insert("Bahut Kasth hein");
		p.insert("Java project is running on eclipse");
		p.removeNextInOrder();
		p.removeNextInOrder();
		p.removeAny();
		p.removeAny();
		p.display();
		System.out.println(p.size());
	}
}
