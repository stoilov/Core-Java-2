//import java.util.Collection;
//import java.util.Iterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import stackImpl.StackImpl;

public class Collections1 {

	public static boolean checkBrackets(String expression) {
		StackImpl stack = new StackImpl(20);
		String[] brackets = expression.split("");

		for (int i = 0; i < brackets.length; i++) {
			if ("(".equals(brackets[i])) {
				stack.push(brackets[i]);
			} else {
				if (stack.length() != 0) {
					stack.pop();
				} else {
					return false;
				}
			}

		}

		return true;
	}

	static void reverse(Collection<Integer> collection) {
		ArrayList<Integer> elements = new ArrayList<Integer>();

		elements.addAll(collection);
		collection.clear();

		for (int i = elements.size() - 1; i >= 0; i--) {
			collection.add(elements.get(i));
		}

	}

	public static void rotate(Collection<Integer> collection, int rotateStep) {
		ArrayDeque<Integer> elements = new ArrayDeque<Integer>();
		elements.addAll(collection);

		int rotateStepAbs = (int) Math.abs(rotateStep);

		for (int i = 0; i < rotateStepAbs; i++) {
			if (rotateStep > 0) {
				elements.addFirst(elements.pollLast());
			} else {
				elements.addLast(elements.pollFirst());
			}
		}

		collection.clear();
		collection.addAll(elements);

	}

	public static int firstUnique(Collection<Integer> collection) {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		elements.addAll(collection);

		for (Iterator<Integer> iterator = elements.iterator(); iterator
				.hasNext();) {
			Integer element = (Integer) iterator.next();
			iterator.remove();
			if (elements.indexOf(element) == -1) {
				return element;
			}

		}

		return 0;
	}

	@SafeVarargs
	public static Set<Integer> duplicating(Set<Integer>... sets) {
		int minLength = 0;
		int index = 0;

		Set<Integer> duplicated = new HashSet<Integer>();

		for (int i = 0; i < sets.length; i++) {
			if (sets[i].size() < minLength) {
				minLength = sets[i].size();
				index = i;
			}
		}

		for (Iterator<Integer> iterator = sets[index].iterator(); iterator
				.hasNext();) {
			Integer element = (Integer) iterator.next();

			int occurenceCount = 0;
			for (int i = 0; i < sets.length; i++) {
				if (i != index && sets[i].contains(element)) {
					occurenceCount++;
				}
			}

			if (occurenceCount == sets.length - 1) {
				duplicated.add(element);
			}

		}

		return duplicated;
	}

	public static String mapString(Map<? extends Object, ? extends Object> hm) {
		String result = "{ ";

		for (Map.Entry<? extends Object, ? extends Object> entry : hm
				.entrySet()) {
			result += String
					.format("%s:%s, ", entry.getKey(), entry.getValue());
		}

		return result += "}";
	}

	public static LinkedHashMap<String, Integer> wordOccurences(String sentence) {
		LinkedHashMap<String, Integer> occurences = new LinkedHashMap<String, Integer>();
		String[] words = sentence.split(" ");

		for (String string : words) {
			occurences.put(string, 0);
		}

		for (String string : words) {
			occurences.put(string, occurences.get(string) + 1);
		}

		return occurences;
	}

	public static void main(String[] args) {
		System.out.println(checkBrackets("()(())"));

		ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,
				6, 7));
		rotate(ints, 1);
		System.out.println(ints);

		Collection<Integer> ints1 = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);
		System.out.println(firstUnique(ints1)); // 2;

		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 5, 6));
		Set<Integer> c = new HashSet<Integer>(Arrays.asList(5, 6, 7, 8));
		System.out.println(duplicating(a, b, c));

		reverse(ints);
		System.out.println(ints);

		System.out
				.println(mapString(wordOccurences("Ninjas are all over the place! We are all going to die!")));
	}

}
