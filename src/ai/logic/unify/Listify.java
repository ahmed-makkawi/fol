package ai.logic.unify;


public class Listify {

	public static LogicList listify(String predicate) throws Exception {
		int bracketOpen, bracketClose;
		String currentPredicateName;
		predicate = predicate.replaceAll("\\s+", "");

		bracketOpen = predicate.indexOf("(");
		bracketClose = predicate.indexOf(")");
		if (bracketClose == -1)
			throw new Exception("Brackets not properly closed");
		currentPredicateName = predicate.substring(0, bracketOpen);
		predicate = predicate.substring(bracketOpen);
		LogicList l = new LogicList(currentPredicateName);
		return helper(predicate, l);
	}

	private static LogicList helper(String predicate, LogicList list)
			throws Exception {
		String[] split = predicate.split(",");
		int bracketOpen, bracketClose;
		String currentPredicateName;
		for (int i = 0; i < split.length; i++) {
			bracketOpen = predicate.indexOf("(");
			if (bracketOpen != -1) {
				bracketClose = predicate.indexOf(")");
				currentPredicateName = predicate.substring(0, bracketOpen);

				list.add(helper(predicate.substring(bracketOpen), list));
			} else {
				list.add(split[i]);
			}
		}
		return list;
	}
}

// Older()
// father(y,x),father(x,y)
// Older
// father(y,x) father(x,y)