package com.yedam.set;

public class Member {
	public String name;
	public int age;

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			if (name.equals(member.name) && age == member.age) {
				return true;
			}
		}
		return false;
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
