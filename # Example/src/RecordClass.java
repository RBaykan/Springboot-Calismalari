import java.util.ArrayList;
import java.util.List;

public class RecordClass {

	public static void main(String[] args) {

		Person person = new Person("Recep", "Baykan");

		System.out.println(people.size());

		Person person2 = new Person("Kral", "Baykan");

		System.out.println(people.size());
		
		System.out.println(person.firstname);

	}

	public static List<Person> people = new ArrayList<Person>();

	public record Person(String firstname, String lastname) {

		public Person {
			boolean isHave = false;
			for (Person p : people) {

				if (p.firstname.equals(firstname)) {

					System.out.println("The People list have same name person!");
					isHave = true;
					break;

				}

			}

			if (!isHave) {
				people.add(this);
			}

		}

	}

}
