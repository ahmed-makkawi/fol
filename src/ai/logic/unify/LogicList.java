package ai.logic.unify;

import java.util.ArrayList;
import java.util.List;

public class LogicList {
	String name;
	List<Object> list;

	public LogicList(String name) {
		this.name = name;
		list = new ArrayList<>();
	}

	public void add(Object o) {
		list.add(o);
	}

}
