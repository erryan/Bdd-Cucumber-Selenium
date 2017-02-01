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
    Then I should see 6 "ul.site-footer-links:nth-child(1) > li" elements

  Scenario: Actions Steps
    Given I am on "https://github.com"
    When  I click on "a.js-selected-navigation-item:nth-child(1)"
    Then  I follow "https://github.com/about"
    Then  the "ul.site-footer-links:nth-child(1) > li" element should exist
    Then  the "ul.site-footer-links:nth-child(1) > sli" element should not exist


