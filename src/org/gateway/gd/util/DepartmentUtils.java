package org.gateway.gd.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gateway.gd.domain.Department;

public class DepartmentUtils {

	/**
	 * 使用递归得到所有部门，并且已经修改了名称以表示层次
	 * 
	 * @param topList
	 * @return
	 */
	public static List<Department> getAllDepartmentList(List<Department> topList) {

		List<Department> list = new ArrayList<Department>();
		walkDepartmentTreeList(topList, "┣", list);
		return list;
	}

	/**
	 * 遍历所有部门树，把遍历出的部门先改名称再放到同一个集合中
	 * 
	 * @param topList
	 * @param prefix
	 * @param list
	 */
	private static void walkDepartmentTreeList(Collection<Department> topList,
			String prefix, List<Department> list) {
		for (Department top : topList) {
			// 修改名称后放到集合中，不要修改原对象，要使用副本，因为原对象在Hibernate Session中
			Department copy = new Department();
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());
			list.add(copy);
			// 处理子树
			walkDepartmentTreeList(top.getChildren(), "　" + prefix, list);// 使用全角空格
		}
	}

	/**
	 * 从集合中移除指定部门及下级部门
	 */
	public static void removeParentAndChildren(List<Department> departmentList,
			Department department) {
		// 移除当前部门
		departmentList.remove(department);
		System.out.println(department.getName());
		// 移除下级部门
		for (Department child : department.getChildren()) {
			removeParentAndChildren(departmentList, child);
		}
	}

}
