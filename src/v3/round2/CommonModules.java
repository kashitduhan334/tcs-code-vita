package v3.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Manoj Khanna
 */

public class CommonModules {

	private static HashMap<Integer, Module> moduleMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] strings = bufferedReader.readLine().split(" ");
		int p = Integer.parseInt(strings[0]),
				m = Integer.parseInt(strings[1]);

		for (int i = 0; i < m; i++) {
			strings = bufferedReader.readLine().split(" ");
			int u = Integer.parseInt(strings[0]),
					v = Integer.parseInt(strings[1]);

			Module vModule = moduleMap.get(v);
			if (vModule == null) {
				vModule = new Module(v);
				moduleMap.put(v, vModule);
			}

			Module uModule = moduleMap.get(u);
			if (uModule == null) {
				uModule = new Module(u);
				moduleMap.put(u, uModule);
			}

			uModule.childModuleSet.add(vModule);
		}

		int q = Integer.parseInt(bufferedReader.readLine());

		HashSet<Integer> resultSet = new HashSet<>();
		for (String string : bufferedReader.readLine().split(" ")) {
			Module module = moduleMap.get(Integer.parseInt(string));
			if (resultSet.isEmpty()) {
				resultSet.addAll(module.getChildNumSet());
				continue;
			}

			Iterator<Integer> iterator = resultSet.iterator();
			while (iterator.hasNext()) {
				if (!module.getChildNumSet().contains(iterator.next())) {
					iterator.remove();
				}
			}
		}

		if (resultSet.isEmpty()) {
			System.out.print("-1");
		} else {
			for (Integer n : resultSet) {
				System.out.print(n + " ");
			}
		}
	}

	private static class Module {

		private int n;
		private HashSet<Module> childModuleSet = new HashSet<>();
		private HashSet<Integer> childNumSet;

		private Module(int n) {
			this.n = n;
		}

		public HashSet<Integer> getChildNumSet() {
			if (childNumSet == null) {
				childNumSet = new HashSet<>();

				for (Module module : childModuleSet) {
					childNumSet.add(module.n);
					childNumSet.addAll(module.getChildNumSet());
				}
			}

			return childNumSet;
		}

	}

}
