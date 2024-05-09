Feature: Get And Post Request Feature

  Background:
    Given set the "base_url"

  @smoke @get_request
  Scenario: Example Get Scenario
    And set the path "pet" with param "10"
    And set the content type to "application"
    When perform a GET request
    Then verify that response status code 200

  @smoke @post_request
  Scenario: Example Post Scenario
    And set the path "pet" with param "10"
    And set the content type to "application/x-www-form-urlencoded"
    When perform a POST request with "hb_api" query
    Then verify that response status code 200

  @smoke @post_request_with_body
  Scenario: Example Post Scenario With Request Body
    And set the path "pet"
    And set the content type to "application"
    When perform a POST request with body
    Then verify that response status code 200