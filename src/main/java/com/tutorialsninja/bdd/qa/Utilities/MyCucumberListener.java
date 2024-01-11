package com.tutorialsninja.bdd.qa.Utilities;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;

public class MyCucumberListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::beforeTestCase);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::afterTestCase);
    }

    private void beforeTestCase(TestCaseStarted event) {
        TestCase testCase = event.getTestCase();
        if (hasMatchingTag(testCase, "@TutorialsNinjaRegister", "@TutorialsNinjaLogin", "@TutorialsNinjaSearchProduct", "@TutorialsNinjaAddtoCart", "@TutorialsNinjaLogout")) {
            // Actions to be performed before the test case
            System.out.println("Before scenario: " + testCase.getName());
        }
    }

    private void afterTestCase(TestCaseFinished event) {
        TestCase testCase = event.getTestCase();
        if (hasMatchingTag(testCase, "@TutorialsNinjaRegister", "@TutorialsNinjaLogin", "@TutorialsNinjaSearchProduct", "@TutorialsNinjaAddtoCart", "@TutorialsNinjaLogout")) {
            // Actions to be performed after the test case
            System.out.println("After scenario: " + testCase.getName());
        }
    }

    private boolean hasMatchingTag(TestCase testCase, String... tags) {
        for (String tag : tags) {
            if (testCase.getTags().contains(tag)) {
                return true;
            }
        }
        return false;
    }
}
