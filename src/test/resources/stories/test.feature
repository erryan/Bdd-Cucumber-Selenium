Feature: Example Feature


  Scenario: Navigations Steps
    Given I am on "https://www.google.com.tr/"
    Then reflesh the page
    Then reload the page
    Then I move backward one page
    Then I move forward one page

  Scenario: Assertion Steps
    Given I am on "https://github.com/"
    When I should see current url as "https://github.com/"
    Then I should see current url path as "/"
    Then I should see page title as "How people build software · GitHub"
    Then I should see text "How people build software"
    Then I should not see text "not text"
    Then I should see text "Personal" in the "body > header > div > div > nav.site-header-nav.site-header-nav-main > a.js-selected-navigation-item.nav-item.nav-item-personal" elements
    Then I should not see text "not text" in the "body > header > div > div > nav.site-header-nav.site-header-nav-main > a.js-selected-navigation-item.nav-item.nav-item-personal" elements
