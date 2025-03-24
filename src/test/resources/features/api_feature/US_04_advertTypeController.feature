@API-US-04

  Feature:
    @ApiAdmin
    Scenario: TC-01 | tam yetkili olarak reklam ilanı verebilmeli
      Given   set the url-
      And     set the expected data-
      When    send request get response
      Then    to do assertion- ilanın verildiği doğrulanır

    Scenario: TC-02 | yetkisiz olarak reklam ilanı verilememeli
      Given   token alınmaz
      And     set the url-
      And     set the expected data-
      When    send request get response
      Then    to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı görülür

    @ApiAdmin
    Scenario:  TC-03	get--oluşturualn reklam get işlemi ile görülebilmeli
      Given    admin olarak token alınır
      And      set the url- url nin sonuna oluşturlan reklamın id si girilir
      And      get işlemi yapılır
      Then     to do assertion- 200 status code ile verilen ilan görünür olır


    Scenario:  TC-04	get--id numarası ile verilen ilanınları yetkisi olmadan görememeli
      Given    token alınmaz
      And      set the url-
      And      set the expected data- url nin sonun id girilir
      When     send request get response
      Then     to do assertion- 401 kodu ile "Full authentication is required to access this resource" mesajı görülür

    Scenario:  TC-05	get--yetkisi olmadan da bütün ilanları görebilmeli
      Given    token alınmaz
      And      herhangi bir hesap oluşturulmaz
      And      set the url-
      When     set the expected data- url nin sonun " all" girilir
      Then     send request get response
