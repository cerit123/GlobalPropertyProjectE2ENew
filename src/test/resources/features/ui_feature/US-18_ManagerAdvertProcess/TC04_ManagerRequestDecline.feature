@US-18 @Manager
Feature: US018_Manager ilanlar ile ilgili islem yapar

    Scenario: Manager ilanlar ile ilgili islem yapar

        Given Homepage e tiklanir.
        And Profil menusunden  My Tour Requests sekmesi tiklanir
        And My Responses listesi acilir.
        And My Responsesdaki ilanda silme(x) tusuna basar
        Then Tour request declined mesajinin gorundugu dogrulanir


