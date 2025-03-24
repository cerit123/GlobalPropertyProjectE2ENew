@API-US-04

  Feature:
    @apiAdmin
    Scenario: TC-01 | tam yetkili olarak reklam ilanı verebilmeli
      Given   set the url
      And     yetkili post işlemi için payload oluşturulur
      When    yetkili yapılan post işlemi için response alınır
      Then    to do assertion- ilanın verildiği doğrulanır

    Scenario: TC-02 | yetkisiz olarak reklam ilanı verilememeli
      Given   token alınmaz
      And     set the url
      And     yetkisiz post işlemi için payload oluşturulur
      When    yetkisiz yapılan post işlemi response alınır
      Then    to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı görülür

    Scenario: TC-03 | yetkisiz olarak reklam ilanı verilememeli
      Given   token alınmaz
      And     set the url
      And     yetkisiz post işlemi için payload oluşturulur
      When    yetkisiz yapılan post işlemi response alınır
      Then    to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı görülür
