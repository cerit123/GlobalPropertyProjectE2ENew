@US-18 @Manager
Feature: US018_Manager ilanlar ile ilgili islem yapar
  Scenario: Manager kendine ait olmayan bir ilan icin istekte bulunabilir

    Given Homepage e tiklanir.
    When Istenilen ilan a tiklanir
    And  Schedule a Tour kismindan tur tarihi secilir.
    And  Schedule a Tour kismindan  tur saati secilir.
    And  Submit a tour request butonu  tiklanir.
    Then Tour Requestin gonderildigi dogrulanir.





