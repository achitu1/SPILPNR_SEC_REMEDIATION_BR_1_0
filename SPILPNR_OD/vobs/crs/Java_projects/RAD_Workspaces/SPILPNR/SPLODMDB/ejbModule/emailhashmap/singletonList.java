package emailhashmap;

import java.util.ArrayList;
import java.util.List;

public class singletonList {
	public List<SingletonListBean> SLB = new ArrayList<SingletonListBean>();

	public void addEmailBean(SingletonListBean e) {
		SLB.add(e);
	}

	public void printBean() {
		for (int i = 0; i < SLB.size(); i++) {
			System.out.println("User ID: " + SLB.get(i).getUserId() + " Email: "
					+ SLB.get(i).getEmail() + " Dep. Airport Code: "
					+ SLB.get(i).getDepAirport() + " Flight Number: "
					+ SLB.get(i).getFlightNumber() + " Dep Date: "
					+ SLB.get(i).getDepDate());
		}
	}

	public void removeBean(SingletonListBean bean) {
		for (int i = 0; i < SLB.size(); i++) {
			if ((bean.getFlightNumber().equals(SLB.get(i).getFlightNumber()))
					&& (bean.getDepAirport().equals(SLB.get(i).getDepAirport()))
					&& (bean.getDepDate().equals(SLB.get(i).getDepDate()))) {
				SLB.remove(i);
			}
		}
	}
}
