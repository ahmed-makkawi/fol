package ai.logic.unify;

import java.util.List;

import org.omg.CORBA.NameValuePair;

public class Unify {

	 
public static List<NameValuePair>Unify(LogicList E1, LogicList E2, List<NameValuePair> subsSet){
	substitute(E1,E2,subsSet);
	if(E1 == E2)
		return subsSet;
	if(E1.size!=E2.size)
		return null;
	for(int i = 0;i<E1.size; i++){
		if(E1.get(i) == E2.get(i))
			continue;
		if(E1.get(i) instanceof list<Object> && E2.get(i) instanceof list<Object> ) //both are lists
			Unify(E1.get(i), E2.get(i), subsSet);

		if(E1.get(i) instanceof list<Object>) //E1 is list
			if(unifyVariable(E1.get(i),E2.get(i), subsSet)==null)
				return null;
		if(E2.get(i) instanceof list<Object>) //E2 is list
			if(unifyVariable(E2.get(i),E1.get(i), subsSet)==null)
				return null;
		unifyVariable(E1.get(i), E2.get(i)); //both are not lists
	}
}
public static void substitute(LogicList E1, LogicList E2, List<NameValuePair> subsSet){
	
}
		
		
UnifyVariable(atom E1, atom E2, subsSet){
	if(E1==E2)
		return subsSet;
	
	if(E1 instanceof constant && E2 instanceof constant)
		return null;
	if(E1 instanceof constant){ //Only E1 is constant
		subsSet.add(E2,E1); //substitue E1 in E2   i.e., T/x
		return subsSet;
	}
	if(E2 instanceof constant){ //E2 is constant
		subsSet.add(E1,E2);
		return subsSet;
	}
	subsSet.add(E2, E1); //both are variables i.e., y/x
}

UnifyVariable(List<Object> E1, atom E2, subsSet){
	List<Object> listE1 = listify(E1);
	if(E1.size!=1)
		return null;
	if(listE1.get(0)==E2)
		return subsSet;
	if(listE1.get(0) instanceof constant && E2 instanceof constant)
		return null;
	if(listE1.get(0) instanceof constant){
		subsSet.add(E2,listE1.get(0));
		return subsSet;
	}
	if(E2 instanceof constant){
		subsSet.add(listE1.get(0),E2);
		return subsSet;
	}
	subsSet.add(E2, listE1.get(0));
}

		
Listify(String x)