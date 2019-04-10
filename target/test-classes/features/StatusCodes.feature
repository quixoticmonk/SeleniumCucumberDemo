Feature:

  Background:
    @statusCode
   Scenario Outline: Validate the Status Code pages
    Given I am on the status Code url "status_codes"
    And I can see the status code "<statusCode>" on the page
    When I select the status code "<statusCode>"
    Then I am navigated to the status code "<statusCode>"  page
    And the message "<statusCodeMessage>" is displayed to the user
    Examples:
      | statusCode | statusCodeMessage                     |
      | 200       | This page returned a 200 status code. |
      | 301       | This page returned a 301 status code. |
      | 404       | This page returned a 404 status code. |
      | 500       | This page returned a 500 status code. |

