Feature: API Tour Requests Testleri
  @apiAdmin
  Scenario: TC01 - Tour Request POST Testi

    Given Submit a tour request gondermek icin URL düzenlenir
    And Tour Request için payload düzenlenir
    When Tour Request için POST request gönderilir ve response alınır
    Then Tour Request için Status Code 200 olduğu doğrulanır


    Scenario: TC02 | Admin olarak tour request onaylanabilmeli

    Given Submit a tour request gondermek icin URL düzenlenir
