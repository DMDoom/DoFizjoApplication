insert into Post (id, author, title, content, createdAt)
    values ('1', 'Mateusz', 'Lorem ipsum', 'Curabitur risus felis', '2017-07-23');

insert into Review (id, author, discipline, opinion)
    values ('1', 'Kuba Tymiński', 'Kadra narodowa Muay Thai, K1', 'Wielkie dzięki Panowie za robotę jaką wykonujecie. Teraz mogę trenować na 100% i nie martwić się o nawracające kontuzje. Od czasu, kiedy zaczęliśmy współpracować bóle nóg i pleców, które towarzyszyły mi parę lat minęły. Naprawdę nie pamiętam kiedy ostatnio byłem tak spokojny o swój organizm. Jeszcze raz dziękuję!');
insert into Review (id, author, discipline, opinion)
    values('2', 'Damian Piskorz', 'Kadra narodowa Muay Thai, K1', 'Od ponad 9 lat jestem związany z kickboxingiem i zdążyłem przekonać się, że praca fizjoterapeuty w naszym życiu odgrywa znacząca rolę. Od stanu naszego zdrowia zależne są wyniki sportowe, które osiągamy. Z chłopakami z DOfizjo współpracuję już od kilku ładnych miesięcy. W ich pracy bardzo szanuję chęć ciągłego rozwoju oraz nieustępliwość w zwalczaniu dolegliwości. Razem pokonaliśmy już wiele kontuzji co zaowocowało kolejnymi tytułami sportowymi. Z czystym sumieniem mogę ich polecić.');
insert into Review (id, author, discipline, opinion)
    values('3', 'Oskar Siegert', 'Kadra narodowa Muay Thai, K1', 'Jestem czynnym zawodnikiem boksu tajskiego i kickboxingu. Często duża ilość jednostek treningowych mocno naraża nasz stan zdrowia na liczne przeciążenia skąd pojawiają się kontuzje. Odkąd współpracujemy, systematyczne wizyty u DOfizjo znacznie zmniejszyły awaryjność mojego ciała, mogę trenować na wyższych obrotach i dawać z siebie 100% na treningach.');
insert into Review (id, author, discipline, opinion)
    values('4', 'Szymon Żelazko', 'Kadra narodowa Muay Thai, K1', 'Skuteczna pomoc w leczeniu urazów, pełne zaangażowanie, wysoka wiedza i świetne podejście do pacjenta. Polecam z czystym sumieniem.');
insert into Review (id, author, discipline, opinion)
    values('5', 'Bartek Najs', 'Trener kalisteniki i zdrowego stylu życia', 'Serdecznie polecam DOfizjo! Dzięki nim osiągniesz swoje rekordy 5 razy szybciej- poprzez przyspieszoną regenerację i złote wskazówki, jak wykonywać poszczególne ruchy efektywniej i efektowniej. W skrócie - SĄ BARDZO SKUTECZNI. Mało tego - działają 24/7, wielokrotnie odzywam się online, by zasięgnąć złotej porady, zawsze otrzymuję odpowiedź. Jeśli chcesz pobić rekord świata. Z DOfizjo pytanie nie brzmi „czy?”, tylko „kiedy”.');

insert into Method (id, name, description)
    values('1', 'Terapia skojarzona', 'Terapia zawierająca w sobie wszystkie metody potrzebne do zmniejszenia lub całkowitego zniesienia bólu.');
insert into Method (id, name, description)
    values('2', 'Terapia powięziowa', 'Jest to praca na tkankach miękkich mająca na celu normalizację napięć, a w efekcie zmniejszenie dolegliwości bólowych w układzie ruchu.');
insert into Method (id, name, description)
    values('3', 'Korekcja wad postawy', 'Terapia mająca na celu zmniejszenie lub wyeliminowanie asymetrii w ciele.');
insert into Method (id, name, description)
    values('4', 'Kinesiotaping', 'Plastrowanie dynamiczne powoduje normalizację napięcia mięśniowego. W zależności od rodzaju aplikacji poprawia ruchomość, zmniejsza dolegliwości bólowe lub wspomaga drenaż limfatyczny.');
insert into Method (id, name, description)
    values('5', 'Masaż klasyczny', 'Powtarzalna sekwencja ruchów - praca na powierzchownych tkankach miękkich, w celu poprawy regeneracji. Niezalecany dla pacjentów bólowych');
insert into Method (id, name, description)
    values('6', 'Terapia bańkami chińskimi', 'Stacjonarne stawianie baniek chińskich lub masaż podciśnieniowy z ich wykorzystaniem.');
insert into Method (id, name, description)
    values('7', 'Wizyty domowe', 'Wizyta w miejscu zamieszkania pacjenta z wykorzystaniem niezbędnego sprzętu do wykonania terapii.');

insert into Block (id, title, content)
    values('zapraszamy', 'zapraszamy', 'Jesteśmy zespołem świadczącym usługi fizjoterapeutyczne w Bydgoszczy, specjalizującym się w sporcie, ortopedii oraz rehabilitacji ruchowej. Pracujemy głównie metodą anatomy trains, pinoterapią oraz kinesiology tapingiem ale na bieżąco rozwijamy swoje umiejętności. Każdy z nas prowadzi aktywne życie sportowca, dzięki czemu wiemy, jak ważne jest dbanie o zdrowy organizm, oraz jak dużą poprawę mogą przynieść regularne wizyty i masaże.');
insert into Block (id, title, content)
    values('oferta', 'oferta', 'Współpracujemy nie tylko ze wszelkiej maści sportowcami, ale także i z pracownikami biurowymi trapionymi przez urazy spowodowane chociażby długotrwałą pracą w pozycji siedzącej. Pamiętaj, że nawet gdy w tej chwili nie czujesz bólu, dobry masaż potrafi znacząco poprawić samopoczucie i zapobiec przyszłym urazom. Nasze usługi oraz odpowiednio dobrane przez nas metody terapii oferujemy zarówno klientom indywidualnym jak i firmom. Zadzwoń już teraz i umów prywatną wizytę w celu analizy i terapii, lub sprawdz naszą ofertę dla firm!');
insert into Block (id, title, content)
    values('mateusz', 'Mateusz Dobrzyński', 'Mateusz jest zapalonym sportowcem, już od wczesnych lat dzieciństwa próbował swoich sił w judo, tenisie ziemnym, piłce nożnej oraz trójboju siłowym. Wszystkie te dyscypliny stały się zapalnikiem w poszerzaniu wiedzy, zarówno z zakresu sportu jak i wpływu aktywności fizycznej na organizm człowieka. Takie zainteresowania przyczyniły się do wyboru studiów fizjoterapeutycznych jako kolejnego etapu edukacji na Wydziale Collegium Medicum. Dzięki wielu godzinom spędzonym na oddziałach ortopedii, rehabilitacji, reumatologii, czy nawet chirurgii ogólnej w szpitalach uniwersyteckich, dokładnie poznał specyfikę pracy fizjoterapeuty. Swoje umiejętności od 2017 roku poszerza w Centrum Medycznym LaserMed.');
insert into Block (id, title, content)
    values('karol', 'Karol Owsiński', 'Karol jest pasjonatem sportu oraz różnych form aktywności fizycznej. Od najmłodszych lat miał kontakt z gimnastyką, a później kalisteniką, którą z czasem zamienił na rzecz treningów trójboju siłowego. Oprócz tego studiował również wychowanie fizyczne, co przybliżyło mu specyfikę sportów drużynowych takich jak np.: siatkówka, czy piłka nożna. Tak bliski kontakt ze sportem pozwala mu doskonale zrozumieć problemy, z jakimi borykają się jego pacjenci, dzięki czemu jest w stanie szybko im pomóc. Praktyki odbył pod okiem specjalistów z „N.Physio” oraz „Body Balance” w Bydgoszczy. Obecnie jest również związany z przychodnią „Przy szpitalu”, gdzie poszerza swoje doświadczenie w pracy z pacjentami bólowymi, ortopedycznymi oraz neurologicznymi.');
insert into Block (id, title, content)
    values('rafal', 'Rafał Płusa', 'Fizjoterapeuta i trener sportów siłowych. W swojej pracy klinicznej często skupia się na poprawie siły swoich klientów, wypracowaniu właściwych nawyków ruchowych i świadomości własnego ciała. Ważna jest dla niego również edukacja i ukierunkowanie pacjenta na właściwe podejście do jego problemu, co zwiększa efektywność współpracy. Poza treningiem fizycznym jego warsztat pracy opiera się na terapii manualnej (zwłaszcza tkanek miękkich), wykorzystuje także suche igłowanie. Rafał posiada również doświadczenie w pracy z pacjentami ze schorzeniami neurologicznymi w pełnym spektrum. W takich przypadkach z pomocą przychodzi mu metoda PNF.');
insert into Block (id, title, content)
    values('metody', 'analiza i terapia', 'Dołożymy wszelkich starań aby adekwatnie dopasować rodzaj terapii do indywidualnych potrzeb pacjenta. Każdy decydujący się na nasze usługi najpierw podlega dokładnej analizie w celu poprawnej identyfikacji źródła dyskomfortu.');
insert into Block (id, title, content)
    values('kontakt', '+48 731 278 308', 'dofizjoterapeuty@gmail.com');
insert into Block (id, title, content)
    values('lokalizacja', 'ul. Jagiellońska 109/23', 'ul. Marii Curie Skłodowskiej 26');

insert into Partner (id, img, name, description)
    values('1', '/images/logos/areadance.png', 'Area Dance', 'Dzięki Area Dance mieliśmy okazję podejrzeć życie tancerza "od kuchni" co wiele nas nauczyło, pozwoliło zrozumieć specyfikę tego sportu i poznać problemy, z którymi borykali się nasi podopieczni tancerze. Dlatego też postanowiliśmy wesprzeć Area Dance, dla którego członków taniec jest niczym powietrze!');
insert into Partner (id, img, name, description)
    values('2', '/images/logos/hazestudio.png', 'Haze Studio', 'Studio tańca, o którym było ostatnio szczególnie głośno, przy okazji ich wielkiego otwarcia. Haze jest miejscem zrzeszającym zajaranych swoją pasją profesjonalistów, których celem jest stworzenie miejsca pełnego muzyki, rozwoju i rodzinnej atmosfery. Ich ambicja i podejście do pracy jest nam bardzo bliskie, dlatego też cieszymy się z współpracy.');
insert into Partner (id, img, name, description)
    values('3', '/images/logos/huntergym.png', 'Hunter Gym', 'Przedstawiamy wam jedną z naszych pierwszych współprac - Hunter Gym. Hunter gym to szkoła walki zajmująca się szkoleniem zawodników Kickboxingu, Muay Thai, K1 i boksu. Naszym zadaniem jest dbać o zdrowie i regenerację chłopaków, podczas ich przygotowań do mistrzostw świata. ');
insert into Partner (id, img, name, description)
    values('4', '/images/logos/organicfitness.jpg', 'Organic Fitness', 'Oto kolejna społeczność, z którą rozpoczęliśmy współpracę. Mowa oczywiście o Organic Fitness.Będziemy regularnie ich odwiedzać i przeprowadzać darmowe warsztaty diagnostyczne z elementami terapii, dlatego też koniecznie śledźcie ich profil, jeśli nie chcecie tego przegapić!');




