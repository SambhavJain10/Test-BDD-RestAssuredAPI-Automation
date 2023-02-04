Feature: listUsers API validation


Scenario: Validate HTTP status Code 200 for API
    Given BaseURL and EndPoint URI is established
    When user calls "listUsersAPI" with GET request
    Then the API call gets success with status code 200