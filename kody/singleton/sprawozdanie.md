#tresc zadania:

You will need to convert the class ReportBuilder to a singleton and experiment the two types of concurrency strategies for a lazy singleton.
Należało przekonwertować klasę ReportBuilder do singletona i przetestować dwa typy strategii współbieżności dla leniwego singletona.

Zmieniłem klasę ReportBuilder, aby zaimplementować wzorzec projektowy Singleton. Uczyniłem konstruktor prywatnym, aby uniemożliwić tworzenie instancji spoza klasy. Następnie zaimplementowałem metodę getInstance(), która zwraca jedyną instancję klasy.

Aby zapewnić bezpieczeństwo wątków podczas leniwego tworzenia instancji singletona, zastosowałem dwie strategie:

    Synchronizacja całej metody getInstance(), co gwarantuje, że tylko jeden wątek na raz może utworzyć instancję klasy. Jest to proste rozwiązanie, ale może wpływać na wydajność z powodu narzutu związanego z synchronizacją.

    Użycie podwójnego sprawdzania blokady (double-checked locking) z wykorzystaniem słowa kluczowego volatile. Ta strategia pozwala na synchronizację tylko podczas pierwszego tworzenia instancji, co poprawia wydajność w porównaniu z pełną synchronizacją metody.

Zmodyfikowanie klasy ReportBuilder polegało na implementacji tych strategii, co pozwoliło na bezpieczne i efektywne tworzenie singletona w środowisku wielowątkowym.
