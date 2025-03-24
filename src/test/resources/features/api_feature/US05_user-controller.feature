
@US05API
Feature: API User Controller Testleri
  @apiAdmin
  Scenario: TC01 - User Register POST Testi

    Given User register için URL düzenlenir
    And User register için payload düzenlenir
    When User register için POST request gönderilir ve response alınır
    Then User register için Status Code 200 olduğu doğrulanır
    And User register için response body dogrulanır



  @apiAdmin
  Scenario: TC02 - User Register GET Testi

    Given User controller GET için URL düzenlenir
    And User controller GET için payload düzenlenir
    When User controller için GET request gönderilir ve response alınır
    Then User controller GET için Status Code 200 olduğu doğrulanır
    And User controller GET için response body dogrulanır