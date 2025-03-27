
@US11TC01
  Feature: API Daily Report Controller Testleri
    @apiAdmin
    Scenario: TC01 - Daily Report GET Testi

      Given Daily Report controller GET için URL düzenlenir
      And Daily Report controller GET için payload düzenlenir
      When Daily Report controller GET istegi gonderilir ve response alinir
      Then Daily Report controller GET istegi status kodu 200 oldugundan emin olunur
      And Daily Report controller GET istegi response body dogrulanir
