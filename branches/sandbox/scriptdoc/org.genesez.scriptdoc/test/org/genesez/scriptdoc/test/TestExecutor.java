package org.genesez.scriptdoc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestExecutor {
	public static void main(String[] args) {
		
		List<Result> testResults = new ArrayList<Result>();
		testResults.add(JUnitCore.runClasses(StatisticHelperTest.class));
		testResults.add(JUnitCore.runClasses(StringHelperTest.class));
		testResults.add(JUnitCore.runClasses(RelativePathTest.class));

		for (Result result : testResults) {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}
		
		System.out.println("Tests executed..");
	}

}
