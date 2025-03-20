@US-12
  Feature:
    Scenario Outline: Search kısmından istediği emlağı seçip genel arama yapabilmeli
      Given Siteye gidilir.
      When Search kisminda bulunan Rent butonuna tiklanir
      And search box ın altındaki emlak "<emlakTürleri>" seçilir
      And search butonuna tiklanir
      Then acilan pencerede seçilen emlakın geldigi gorunur
      Then sayfa kapatilir.

      Examples:
        | emlakTürleri |
        | HOUSE        |
        | APARTMENT    |
        | OFFICE       |
        | VILLA        |
        | LAND         |
        | SHOP         |
