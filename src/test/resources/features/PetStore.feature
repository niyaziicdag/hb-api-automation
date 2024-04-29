Feature: Get Post Request Feature

  Background:
    Given Set the "base_url"
    And Set the content type to "application"

  @smoke @get_request
  Scenario: Example Get Scenario
    And Set the path "pet" with param "1"
    When Perform a GET request
    Then Verify that response status code 200

  @smoke @post_request
  Scenario: Example Post Scenario
    And Set the path "pet" with param "10"
    When Perform a POST request with "doggie" query
    Then Verify that response status code 200