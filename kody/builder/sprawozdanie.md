#Zadanie 2

tresc zadania:
    First, the program it’s not closed for modification but open for extension. Whenever you need to add a new type of ReportBody you don’t have any extension hook, so you will have to modify the ReportAssembler code. The other principle this program is violating is the Dependency Inversion Principle. This principle states that higher modules in abstraction should not depend on concrete implementations of lower modules in abstraction. This is violated because ReportAssembler depends on concrete implementations of ReportBody which are lower modules in abstraction.

nalezalo zaimplementowac wzorzec projektowy Builder dodajac odpowiednie klasy dla obslugi roznych typow reportow.
Stworzylem interface ReportBuilder ktory implementuja klasy <typ>ReportBuilder, trzymajac sie zasady open-close (zgodnie z 1 punktem). Nastepnie zaimplementowalem factory, ktora jest odpowiedzialna za wybor odpowiedniego buildera w zaleznosci od typu reportu.
Zmodyfikowanie ReportAssemblera polegalo na implementacji nowego kodu...
