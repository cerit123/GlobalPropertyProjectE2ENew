@APIOsman
Feature: API Tour Requests Testleri
  @apiAdmin
  Scenario: TC01 - Tour Request POST Testi

    Given Submit a tour request gondermek icin URL düzenlenir.
    And Tour Request için payload düzenlenir.
    When Tour Request için POST request gönderilir ve response alınır.
    Then Tour Request için Status Code 200 olduğu doğrulanır.

  @apiAdmin
  Scenario: TC02 | Admin olarak tour request onaylanabilmeli

    Given Url Get requeste gore duzenlenir.
    And Get request gonderilir ve response alinır.
    Then Status Code 200 oldugundan emin olunur.

  @apiAdmin

  Scenario: TC03 | Admin olarak tour requesti cancel yapabilmeli

    Given Url Cancel requeste gore duzenlenir.
    And Get request gonderilir ve response alinır.
    Then Status Code 200 oldugundan emin olunur.

  @apiAdmin

  Scenario: TC04 | Admin olarak tour requesti degistirebilmeli

    Given Url Put requeste gore duzenlenir.
    And Put islemi icin payload olusturulur.
    And Put request gonderilir ve response alinir.
    Then Status Code 200 oldugundan emin olunur.

  @apiAdmin

  Scenario: TC05 | Admin olarak tour requesti decline edebilmeli

    Given Url decline requeste gore duzenlenir.
    And Get request gonderilir ve response alinir.
    Then Status Code 200 oldugundan emin olunur.

  @apiAdmin

  Scenario: TC06 | Admin olarak tour requestleri gorebilmeli

    Given Url tour request gormek icin duzenlenir.
    And Get request gonderilir ve response alinir.
    Then Status Code 200 oldugundan emin olunur.

  @apiAdmin

  Scenario: TC07 | Admin olarak tour requesti delete edebilmeli

    Given Url tour requesti silmek icin duzenlenir.
    And Delete request gonderilir ve response alinir.
    Then Status Code 200 oldugundan emin olunur.
