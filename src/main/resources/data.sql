DROP DATABASE bookworm_db;

CREATE DATABASE IF NOT EXISTS bookworm_db;

USE bookworm_db;


INSERT INTO USER(first_name, last_name, username, email, password, bio, PROFILE_PICTURE_PATH)
    VALUES
        ('bobby', 'smith', 'bobbysmith', 'bobbysmith@email.com', 'bobby', 'Bobby Smith, 28 🎸 | Music lover, aspiring guitarist, and storytelling enthusiast. Strumming through life''s rhythm with a passion for tunes and tales.','https://images.unsplash.com/photo-1522075469751-3a6694fb2f61?q=80&w=3220&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
        ('lucy', 'smith', 'lucysmith', 'lucysmith@email.com', 'lucy', 'Lucy Smith, 22 📚 | Bookworm and review maven. Navigating the literary world one page at a time. Join me on my reading journey! 📖✨ #BookReviewer', 'https://plus.unsplash.com/premium_photo-1683140621573-233422bfc7f1?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHByb2ZpbGUlMjBpbWFnZXxlbnwwfHwwfHx8MA%3D%3D'),
        ('chris', 'smith', 'chrissmith', 'chrissmith@email.com', 'chris', 'This is a test bio for chris', null),
        ('peter', 'griffen', 'petergriffen', 'peterg@email.com', 'peter', 'This is a test bio for peter', 'https://images.unsplash.com/photo-1601233749202-95d04d5b3c00?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzB8fHByb2ZpbGUlMjBpbWFnZXxlbnwwfHwwfHx8MA%3D%3D'),
        ('lance', 'smith', 'lancesmith', 'lancesmith@email.com', 'lance', 'This is a test bio for lance', 'https://images.unsplash.com/photo-1517598024396-46c53fb391a1?q=80&w=3456&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');



INSERT INTO BOOKSHELF(book_id, isbn, book_title, author, data_published, cover_page, description, page_count, genre, rating, google_play)
    VALUES
        (1, 9781781100486,'Harry Potter and the Philosophers Stone',' J.K. Rowling.', 'June 26, 1997', 'https://books.google.com/books/content?id=4fzzAAAACAAJ&printsec=frontcover&img=1&zoom=1&imgtk=AFLRE71WudE90hH4zO__kzqQ-3tVf5E7ToRM3CBeKvtjfCWAWi7HM0m09PCt1iwXF9iv9BxXfWL3OuVGy7cgHNUlaa1qbcT-JuCYWMOS_FHHNXYX7-GkKiTWqQt1oGtA5S35OBmONRt7', 'Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. Then, on Harry''s eleventh birthday, a great beetle-eyed giant of a man called Rubeus Hagrid bursts in with some astonishing news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!', '353','adventure', 4, 'https://play.google.com/store/books/details/J_K_Rowling_Harry_Potter_and_the_Sorcerer_s_Stone?id=wrOQLV6xB-wC'),
        (2, 9780385372053,'Horton Hears a Who!', 'Dr. Seuss', 'Sept 24, 2013', 'http://books.google.com/books/content?id=OIwaMQAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 'Everyone''s favorite elephant stars in this heartwarming and timeless story for readers of all ages. In the colorful Jungle of Nool, Horton discovers something that at first seems impossible: a tiny speck of dust contains an entire miniature world--Who-ville--complete with houses and grocery stores and even a mayor! But when no one will stand up for the Whos of Who-ville, Horton uses his elephant-sized heart to save the day.', 72, 'Children',4, 'https://play.google.com/store/books/details/Dr_Seuss_Horton_Hears_a_Who?id=AbLxAwAAQBAJ'),
        (3, 9781612680019, 'Rich Dad, Poor Dad', 'Robert T. Kiyosaki', 'August 16, 2011', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1590522901l/53491356._SY475_.jpg', 'In Rich Dad Poor Dad, the #1 Personal Finance book of all time, Robert Kiyosaki shares the story of his two dad: his real father, whom he calls his poor dad,’ and the father of his best friend, the man who became his mentor and his rich dad.’ One man was well educated and an employee all his life, the other’s education was street smarts” over traditional classroom education and he took the path of entrepreneurship a road that led him to become one of the wealthiest men in Hawaii. Robert’s poor dad struggled financially all his life, and these two dads these very different points of view of money, investing, and employment shaped Robert’s thinking about money.', '243', 'business', 4, 'https://play.google.com/store/books/details/Robert_T_Kiyosaki_Rich_Dad_Poor_Dad_Edisi_Bahasa_M?id=dYv1AgAAQBAJ'),
        (4, 9780062301260,'Elon Musk', 'Ashlee Vance', 'May 19, 2015', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1518291452l/25541028.jpg', 'In the spirit of Steve Jobs and Moneyball, Elon Musk is both an illuminating and authorized look at the extraordinary life of one of Silicon Valley’s most exciting, unpredictable, and ambitious entrepreneurs—a real-life Tony Stark—and a fascinating exploration of the renewal of American invention and its new “makers.”Elon Musk spotlights the technology and vision of Elon Musk, the renowned entrepreneur and innovator behind SpaceX, Tesla, and SolarCity, who sold one of his Internet companies, PayPal, for $1.5 billion. Ashlee Vance captures the full spectacle and arc of the genius’s life and work, from his tumultuous upbringing in South Africa and flight to the United States to his dramatic technical innovations and entrepreneurial pursuits.', 416, 'biography', 4, 'https://play.google.com/store/books/details/Ashlee_Vance_Elon_Musk?id=Yd99BAAAQBAJ'),
        (5, 9780525533634, 'Iron Ambition My Life with Cus D Amato', 'Mike Tyson', 'May 22, 2018', 'https://prodimage.images-bn.com/pimages/9780399177033_p0_v3_s1200x630.jpg','In Tyson\’s bestselling memoir Undisputed Truth, he recounted the role D\’Amato played in his formative years, adopting him at age sixteen after his mother died and shaping him both physically and mentally after Tyson had spent years living in fear and poverty. In Iron Ambition, Tyson elaborates on the life lessons that D\’Amato passed down to him, and reflects on how the trainer\’s words of wisdom continue to resonate with him outside the ring. The book also chronicles Cus’s courageous fight against the mobsters who controlled boxing, revealing more than we\’ve ever known about this singular cultural figure.', 480, 'biography',3, 'https://play.google.com/store/books/details/Mike_Tyson_Iron_Ambition?id=s5LZDAAAQBAJ'),
        (6, 9780307414090, 'Tuesdays with Morrie', 'Mitch Albom','June 29, 2007', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1423763749l/6900.jpg', 'Maybe it was a grandparent, or a teacher or a colleague. Someone older, patient and wise, who understood you when you were young and searching, and gave you sound advice to help you make your way through it. For Mitch Albom, that person was Morrie Schwartz, his college professor from nearly twenty years ago. Maybe, like Mitch, you lost track of this mentor as you made your way, and the insights faded.  Wouldnt you like to see that person again, ask the bigger questions that still haunt you? Mitch Albom had that second chance. He rediscovered Morrie in the last months of the older mans life. Knowing he was dying of ALS - or motor neurone disease - Mitch visited Morrie in his study every Tuesday, just as they used to back in college. Their rekindled relationship turned into one final class: lessons in how to live.',192, 'biography', 4, 'https://play.google.com/store/books/details/Mitch_Albom_Tuesdays_with_Morrie?id=z2z_6hLoPmgC'),
        (7, 9780143309000, 'Old School', 'Jeff Kinney', 'Nov 3, 2015', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1430174375l/25222064.jpg', 'Life was better in the old days. Or was it? That’s the question Greg Heffley is asking as his town voluntarily unplugs and goes electronics-free. But modern life has its conveniences, and Greg isn’t cut out for an old-fashioned world. With tension building inside and outside the Heffley home, will Greg find a way to survive? Or is going “old school” just too hard for a kid like Greg?', 224, 'children', 4, 'https://play.google.com/store/books/details/Jeff_Kinney_Old_School_Diary_of_a_Wimpy_Kid_10?id=tNClBwAAQBAJ'),
        (8,9780812998610, 'The Girls', 'Emma Cline', 'June 14, 2016', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1492065338l/26893819.jpg', 'Northern California, during the violent end of the 1960s. At the start of summer, a lonely and thoughtful teenager, Evie Boyd, sees a group of girls in the park, and is immediately caught by their freedom, their careless dress, their dangerous aura of abandon. Soon, Evie is in thrall to Suzanne, a mesmerizing older girl, and is drawn into the circle of a soon-to-be infamous cult and the man who is its charismatic leader. Hidden in the hills, their sprawling ranch is eerie and run down, but to Evie, it is exotic, thrilling, charged—a place where she feels desperate to be accepted. As she spends more time away from her mother and the rhythms of her daily life, and as her obsession with Suzanne intensifies, Evie does not realize she is coming closer and closer to unthinkable violence, and to that moment in a girl’s life when everything can go horribly wrong.', 355, 'fiction',3, 'https://play.google.com/store/books/details/Emma_Cline_The_Girls?id=aJeTCgAAQBAJ'),
        (9,9781501171369 ,'The Last Thing He Told Me', 'laura dave', 'May 4, 2021', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1638326218l/59733214._SX318_.jpg', 'Before Owen Michaels disappears, he manages to smuggle a note to his beloved wife of one year: Protect her. Despite her confusion and fear, Hannah Hall knows exactly to whom the note refers: Owen’s sixteen-year-old daughter, Bailey. Bailey, who lost her mother tragically as a child. Bailey, who wants absolutely nothing to do with her new stepmother. As Hannah’s increasingly desperate calls to Owen go unanswered; as the FBI arrests Owen’s boss; as a US Marshal and FBI agents arrive at her Sausalito home unannounced, Hannah quickly realizes her husband isn’t who he said he was. And that Bailey just may hold the key to figuring out Owen’s true identity—and why he really disappeared.', 320,  'Thriller', 3, 'https://play.google.com/store/books/details/Laura_Dave_The_Last_Thing_He_Told_Me?id=3s8DEAAAQBAJ'),
        (10, 9780345816023, '12 Rules for Life', 'Jordan B. Peterson', 'January 23, 2018','https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1512705866l/30257963.jpg', 'Humorous, surprising and informative, Dr. Peterson tells us why skateboarding boys and girls must be left alone, what terrible fate awaits those who criticize too easily, and why you should always pet a cat when you meet one on the street.', 409,  'self-help', 4, 'https://play.google.com/store/books/details/Jordan_B_Peterson_12_Rules_for_Life?id=TvEqDAAAQBAJ'),
        (11,9780062868954, 'The Guest List', 'Lucy Foley', 'June 2, 2020','https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1580194251l/51933429.jpg',  'A wedding celebration turns dark and deadly in this deliciously wicked and atmospheric thriller reminiscent of Agatha Christie from the New York Times bestselling author of The Hunting Party. On an island off the coast of Ireland, guests gather to celebrate two people joining their lives together as one. The groom: handsome and charming, a rising television star. The bride: smart and ambitious, a magazine publisher. It’s a wedding for a magazine, or for a celebrity: the designer dress, the remote location, the luxe party favors, the boutique whiskey. The cell phone service may be spotty and the waves may be rough, but every detail has been expertly planned and will be expertly executed. But perfection is for plans, and people are all too human. As the champagne is popped and the festivities begin, resentments and petty jealousies begin to mingle with the reminiscences and well wishes. The groomsmen begin the drinking game from their school days. The bridesmaid not-so-accidentally ruins her dress. The bride’s oldest (male) friend gives an uncomfortably caring toast. And then someone turns up dead. Who didn’t wish the happy couple well? And perhaps more important, why?', 336,  'thriller', 3, 'https://play.google.com/store/books/details/Lucy_Foley_The_Guest_List?id=ibioDwAAQBAJ'),
        (12, 9781538728536, 'Every Breath', 'Nicholas Sparks', 'October 16, 2018', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1521763937l/38212843._SY475_.jpg', 'Treat yourself to an epic #1 New York Times bestselling love story that spans decades and continents as two people at a crossroads -- one from North Carolina and one from Zimbabwe -- experience the transcendence and heartbreak of true love.Hope Anderson has some important choices to make. At thirty-six, she''s been dating her boyfriend, an orthopedic surgeon, for six years. With no wedding plans in sight, and her father recently diagnosed with ALS, she decides to use a week at her family''s cottage in Sunset Beach, North Carolina, to ready the house for sale and mull over some difficult decisions about her future.', 320, 'Romance', 4, 'https://play.google.com/store/books/details/Nicholas_Sparks_Every_Breath?id=cVhIDwAAQBAJ'),
        (13, 9780385385206, 'The Maze Runner', 'James Dashner', 'August 5, 2014', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1375596592l/6186357.jpg', 'Perfect for fans of Divergent and The Hunger Games, this special movie tie-in edition of the first book in the #1 New York Times bestselling Maze Runner series, The Maze Runner, features an eight-page full-color insert with photos from the film and an exclusive fan sticker. The first three books, The Maze Runner, The Scorch Trials, and The Death Cure are all now major motion pictures featuring the star of MTV''s Teen Wolf, Dylan O''Brien, as Thomas; Kaya Scodelario as Teresa; Aml Ameen as Alby; Will Poulter as Gally; and Thomas Brodie-Sangster as Newt! And look for James Dashner''s newest novels, The Eye of Minds and The Rule of Thoughts, the first two books in the Mortality Doctrine series. Nice to meet ya, shank. Welcome to the Glade.', 375,  'fiction', 4, 'https://play.google.com/store/books/details/James_Dashner_The_Maze_Runner_Maze_Runner_Book_One?id=6gfDfhmmHxMC'),
        (14, 9781982110598, 'The Institute', 'Stephen King','September 10, 2019', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1549241208l/43798285.jpg', 'In the middle of the night, in a house on a quiet street in suburban Minneapolis, intruders silently murder Luke Ellis’s parents and load him into a black SUV. The operation takes less than two minutes. Luke will wake up at The Institute, in a room that looks just like his own, except there’s no window. And outside his door are other doors, behind which are other kids with special talents—telekinesis and telepathy—who got to this place the same way Luke did: Kalisha, Nick, George, Iris, and ten-year-old Avery Dixon. They are all in Front Half. Others, Luke learns, graduated to Back Half, “like the roach motel,” Kalisha says. “You check in, but you don’t check out.”', 576,  'Thriller', 4, 'https://play.google.com/store/books/details/Stephen_King_The_Institute?id=iSKGDwAAQBAJ'),
        (15, 9781472280848,'Greenlights', 'Matthew McConaughey', 'October 20, 2020', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1604281659l/52838315._SX318_.jpg', 'I''ve been in this life for fifty years, been trying to work out its riddle for forty-two, and been keeping diaries of clues to that riddle for the last thirty-five. Notes about successes and failures, joys and sorrows, things that made me marvel, and things that made me laugh out loud. How to be fair. How to have less stress. How to have fun. How to hurt people less. How to get hurt less. How to be a good man. How to have meaning in life. How to be more me.', 289,  'biography',4, 'https://play.google.com/store/books/details/Matthew_McConaughey_Greenlights?id=sULYDwAAQBAJ'),
        (16, 9780062002945, 'Sh*t My Dad Says', 'Justin Halpern', 'May 4, 2010', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1370399211l/7821447.jpg', 'Tuesdays with Morrie meets F My Life in this hilarious book about a son’s relationship with his foul-mouthed father by the 29-year-old comedy writer who created the massively popular Twitter feed of the same name.', 176,  'Humor', 4, 'https://play.google.com/store/books/details/Justin_Halpern_Sh_t_My_Dad_Says?id=mU5d_xwMD2cC'),
        (17, 9780316027656, 'Eclipse', 'Stephenie Meyer', 'August 4, 2009', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361038355l/428263.jpg', 'As the love triangle heats up in the third book, Bella must choose between her friendship with Jacob and her romance with Edward -- and her decision could change the fate of vampires and werewolves forever. As Seattle is ravaged by a string of mysterious killings and a malicious vampire continues her quest for revenge, Bella once again finds herself surrounded by danger. In the midst of it all, she is forced to choose between her love for Edward and her friendship with Jacob -- knowing that her decision has the potential to ignite the ageless struggle between vampire and werewolf. With her graduation quickly approaching, Bella has one more decision to make: life or death. But which is which?', 629, 'Romance', 3, 'https://play.google.com/store/books/details/Stephenie_Meyer_Eclipse?id=lw99Oii9R90C'),
        (18, 9781476733500, 'The Gene', 'Siddhartha Mukherjee', 'May 17, 2016', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1452452965l/27276428._SY475_.jpg', 'The story of the gene begins in an obscure Augustinian abbey in Moravia in 1856 where a monk stumbles on the idea of a ‘unit of heredity’. It intersects with Darwin’s theory of evolution, and collides with the horrors of Nazi eugenics in the 1940s. The gene transforms post-war biology. It reorganizes our understanding of sexuality, temperament, choice and free will. This is a story driven by human ingenuity and obsessive minds – from Charles Darwin and Gregor Mendel to Francis Crick, James Watson and Rosalind Franklin, and the thousands of scientists still working to understand the code of codes.', 592,  'History', 3, 'https://play.google.com/store/books/details/Siddhartha_Mukherjee_The_Gene?id=fOvaCgAAQBAJ'),
        (19, 9781982131807, 'Doctor Sleep', 'Stephen King', 'September 24, 2019', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1510335480l/16130549._SY475_.jpg', 'Years ago, the haunting of the Overlook Hotel nearly broke young Dan Torrance’s sanity, as his paranormal gift known as “the shining” opened a door straight into hell. And even though Dan is all grown up, the ghosts of the Overlook—and his father’s legacy of alcoholism and violence—kept him drifting aimlessly for most of his life. Now, Dan has finally found some order in the chaos by working in a local hospice, earning the nickname “Doctor Sleep” by secretly using his special abilities to comfort the dying and prepare them for the afterlife. But when he unexpectedly meets twelve-year-old Abra Stone—who possesses an even more powerful manifestation of the shining—the two find their lives in sudden jeopardy at the hands of the ageless and murderous nomadic tribe known as the True Knot, reigniting Dan’s own demons and summoning him to battle for this young girl’s soul and survival...', 544, 'thriller', 4, 'https://play.google.com/store/books/details/Stephen_King_Doctor_Sleep?id=9mEh1dJTw5cC'),
        (20, 9780062268372, 'Yes Please', 'Amy Poehler', 'October 28, 2014', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1402815435l/20910157.jpg', 'Amy, Yes Please is a rich and varied collection of stories, lists, poetry (Plastic Surgery Haiku, to be specific), photographs, mantras and advice. With chapters like "Treat Your Career Like a Bad Boyfriend," "Plain Girl Versus the Demon" and "The Robots Will Kill Us All" Yes Please will make you think as much as it will make you laugh. Honest, personal, real, and righteous, Yes Please is full of words to live by.', 384,  'Humor', 3, 'https://play.google.com/store/books/details/Amy_Poehler_Yes_Please?id=5upzAwAAQBAJ'),
        (21, 9781607747314, 'The Life-Changing Magic of Tidying Up','Marie Kondo', 'October 14, 2014', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1418767178l/22318578.jpg', 'Japanese cleaning consultant Marie Kondo takes tidying to a whole new level, promising that if you properly simplify and organize your home once, you’ll never have to do it again. Most methods advocate a room-by-room or little-by-little approach, which doom you to pick away at your piles of stuff forever. The KonMari Method, with its revolutionary category-by-category system, leads to lasting results. In fact, none of Kondo’s clients have lapsed (and she still has a three-month waiting list).', 224, 'self-help', 4, 'https://play.google.com/store/books/details/Marie_Kondo_The_Life_Changing_Magic_of_Tidying_Up?id=ahCjAwAAQBAJ'),
        (22, 9781779501127, 'Watchmen','Alan Moore', 'May 20, 2019', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1442239711l/472331.jpg', 'A hit HBO original series, Watchmen, the groundbreaking series from award-winning author Alan Moore, presents a world where the mere presence of American superheroes changed history--the U.S. won the Vietnam War, Nixon is still president, and the Cold War is in full effect.', 448,  'fantasy', 4, 'https://play.google.com/store/books/details/Alan_Moore_Watchmen_2019_Edition?id=EOObDwAAQBAJ'),
        (23, 9780385372015, 'The Cat in the Hat', 'Dr. Seuss', 'September 24, 2013', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1468890477l/233093._SX318_.jpg', 'A dreary day turns into a wild romp when this beloved story introduces readers to the Cat in the Hat and his troublemaking friends, Thing 1 and Thing 2. A favorite among kids, parents and teachers, this story uses simple words and basic ryhme to encourage and delight beginning readers.', 72,  'children', 4, 'https://play.google.com/store/books/details/Dr_Seuss_The_Cat_in_the_Hat?id=ia7xAwAAQBAJ'),
        (24, 9780446576314, 'Delivering Happiness', 'Tony Hsieh', 'June 7, 2010', 'https://www.google.com/books/edition/Delivering_Happiness/RiH9CEQZcOMC?hl=en&gbpv=0', 'In Delivering Happiness, Zappos CEO Tony Hsieh shares the different lessons he has learned in business and life, from starting a worm farm to running a pizza business, through LinkExchange, Zappos, and more. Fast-paced and down-to-earth, Delivering Happiness shows how a very different kind of corporate culture is a powerful model for achieving success-and how by concentrating on the happiness of those around you, you can dramatically increase your own. #1 New York Timesand Wall Street Journal bestseller', 272,  'business', 4, 'https://play.google.com/store/books/details/Tony_Hsieh_Delivering_Happiness?id=RiH9CEQZcOMC'),
        (25, 9780446930642, 'the Notebook', 'Nicholas Sparks', 'Janurary 5, 2000', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483183484l/33648131._SY475_.jpg', 'At thirty-one, Noah Calhoun, back in coastal North Carolina after World War II, is haunted by images of the girl he lost more than a decade earlier. At twenty-nine, socialite Allie Nelson is about to marry a wealthy lawyer, but she cannot stop thinking about the boy who long ago stole her heart. Thus begins the story of a love so enduring and deep it can turn tragedy into triumph, and may even have the power to create a miracle.', 224,  'romance', 4, 'https://play.google.com/store/books/details/Nicholas_Sparks_The_Notebook?id=Vv0og8FYLc8C'),
        (26, 9780679604365, 'The Tigers Wife', 'Tea Obreht', 'March 8, 2011', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1382570044l/8366402.jpg', 'In a Balkan country mending from war, Natalia, a young doctor, is compelled to unravel the mysterious circumstances surrounding her beloved grandfather’s recent death. Searching for clues, she turns to his worn copy of The Jungle Book and the stories he told her of his encounters over the years with “the deathless man.” But most extraordinary of all is the story her grandfather never told her—the legend of the tiger’s wife.', 337,  'fiction', 3, 'https://play.google.com/store/books/details/T%C3%A9a_Obreht_The_Tiger_s_Wife?id=iANCcNsVbzcC'),
        (27, 9780062999696, 'Falling Up', 'Shel Silverstein', 'October 20, 2020', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1327871908l/30120.jpg', 'Filled with unforgettable characters like Screamin’ Millie; Allison Beals and her twenty-five eels; Danny O''Dare, the dancin'' bear; the Human Balloon; and Headphone Harold, this collection by the celebrated Shel Silverstein will charm young readers and make them want to trip on their shoelaces and fall up too!', 184,  'children', 4, 'https://play.google.com/store/books/details/Shel_Silverstein_Falling_Up?id=XlrMDwAAQBAJ'),
        (28, 9781781100486, 'Harry Potter and the Sorcerers Stone', 'J.K. Rowling', 'December 8, 2015', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1474154022l/3._SY475_.jpg', 'In Harry Potter and the Sorcerer''s Stone, Harry, an orphan, lives with the Dursleys, his horrible aunt and uncle, and their abominable son, Dudley. One day just before his eleventh birthday, an owl tries to deliver a mysterious letter?the first of a sequence of events that end in Harry meeting a giant man named Hagrid. Hagrid explains Harry''s history to him: When he was a baby, the Dark wizard, Lord Voldemort, attacked and killed his parents in an attempt to kill Harry; but the only mark on Harry was a mysterious lightning-bolt scar on his forehead. Now he has been invited to attend Hogwarts School of Witchcraft and Wizardry, where the headmaster is the great wizard Albus Dumbledore. Harry visits Diagon Alley to get his school supplies, especially his very own wand.', 309, 'fantasy', 4, 'https://play.google.com/store/books/details/J_K_Rowling_Harry_Potter_and_the_Sorcerer_s_Stone?id=wrOQLV6xB-wC'),
        (29, 9780525555377, 'Turtles All the Way Down', 'John Green', 'October 10, 2017', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1503002776l/35504431._SY475_.jpg', 'JOHN GREEN, the acclaimed author of Looking for Alaska and The Fault in Our Stars, returns with a story of shattering, unflinching clarity in this brilliant novel of love, resilience, and the power of lifelong friendship.', 320,  'fiction', 3, 'https://play.google.com/store/books/details/John_Green_Turtles_All_the_Way_Down?id=440oDwAAQBAJ'),
        (30, 9781432839680, '1984', 'George Orwell', 'June 8, 1949', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1532714506l/40961427._SX318_.jpg', 'Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale written by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell''s ninth and final book completed in his lifetime.', 320, 'fiction', 4, 'https://play.google.com/store/books/details/George_Orwell_1984?id=kotPYEqx7kMC');







INSERT INTO USER_REVIEWS(REVIEW_ID, BODY, rating, TITLE, BOOKSHELF_ID, user_id)
VALUES
    (1, 'I fell in love with this book, my all time favorite. thank you',5,'LOVE!!!',1,1),
    (2, 'ional relationships, including Marty`s with his first ex-wife Bunny. He reconnects with Bunny when they are both in rehab in Malibu. Marty has a history of bad relationships and is currently in one with Gail who seems to only want his money, never minding Marty is practically out of his. There is a wide range of personalities in the characters in the book.',5,'Childhood Restored',2,1),
    (3, 'his was a very dark and intense reading experience for me. It has a dystopian, hypnotic quality to it. It is a book that needs to be pulled apart and talked about and analysed. Everything that happens in this book can be seen from many different angles and you may change your mind several times about which of the characters are the ones to be feared. A good choice if you are looking for something introspective that will leave you thinking.',5,'What a Read',3,1),
    (4, 'I fell in love with this book, my all time favorite. thank you',5,'lets Explore',4,1),
    (5, 'Im finding this a hard review to put into words. Reminiscent of a Stephen King book at times, especially The Dome, this was enjoyable without too much craziness.',5,'journey is amazing app',5,1),
    (6, 'I simply cannot fathom how this book got so many good reviews. I thought the plot line was ridiculous, and it was poorly written and filled with cardboard characters that I couldnt care less about. Virtually everyone in this book was either a psychopath who blithely committed murder or a cynic who moved through life with hardly any redeeming qualities',5,'Fell in love',6,1),
    (7, 'I fell in love with this book, my all time favorite. thank you',5,'Mind is amazing',7,1),
    (8, 'Al I need was a little wine and this is awesome book. I have nothing but love.',5,'Wine and Read',8,1),
    (9, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',9,1),
    (10, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',10,1),
    (11, 'I fell in love with this book, my all time favorite. thank you',5,'LOVE!!!',11,2),
    (12, 'Im finding this a hard review to put into words. Reminiscent of a Stephen King book at times, especially The Dome, this was enjoyable without too much craziness.',5,'Childhood Restored',12,2),
    (13, 'I fell in love with this book, my all time favorite. thank you',5,'What a Read',13,2),
    (14, 'I fell in love with this book, my all time favorite. thank you',5,'lets Explore',14,2),
    (15, 'his was a very dark and intense reading experience for me. It has a dystopian, hypnotic quality to it. It is a book that needs to be pulled apart and talked about and analysed. Everything that happens in this book can be seen from many different angles and you may change your mind several times about which of the characters are the ones to be feared. A good choice if you are looking for something introspective that will leave you thinking.',5,'journey is amazing app',15,2),
    (16, 'I fell in love with this book, my all time favorite. thank you',5,'Fell in love',16,2),
    (17, 'I fell in love with this book, my all time favorite. thank you',5,'Mind is amazing',17,2),
    (18, 'Al I need was a little wine and this is awesome book. I have nothing but love.',15,'Wine and Read',18,2),
    (19, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',19,2),
    (20, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',20,2),
    (21, 'I simply cannot fathom how this book got so many good reviews. I thought the plot line was ridiculous, and it was poorly written and filled with cardboard characters that I couldnt care less about. Virtually everyone in this book was either a psychopath who blithely committed murder or a cynic who moved through life with hardly any redeeming qualities',5,'LOVE!!!',21,3),
    (22, 'I fell in love with this book, my all time favorite. thank you',5,'Childhood Restored',22,3),
    (23, 'Im finding this a hard review to put into words. Reminiscent of a Stephen King book at times, especially The Dome, this was enjoyable without too much craziness.',5,'What a Read',23,3),
    (24, 'I fell in love with this book, my all time favorite. thank you',5,'lets Explore',24,3),
    (25, 'his was a very dark and intense reading experience for me. It has a dystopian, hypnotic quality to it. It is a book that needs to be pulled apart and talked about and analysed. Everything that happens in this book can be seen from many different angles and you may change your mind several times about which of the characters are the ones to be feared. A good choice if you are looking for something introspective that will leave you thinking.',5,'journey is amazing app',25,3),
    (26, 'I fell in love with this book, my all time favorite. thank you', 5, 'Fell in love',26,3),
    (27, 'I fell in love with this book, my all time favorite. thank you', 5, 'Mind is amazing',27,3),
    (28, 'Al I need was a little wine and this is awesome book. I have nothing but love.',15,'Wine and Read',28,3),
    (29, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',29,3),
    (30, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',30,3),
    (31, 'I fell in love with this book, my all time favorite. thank you',5,'LOVE!!!',2,4),
    (32, 'I simply cannot fathom how this book got so many good reviews. I thought the plot line was ridiculous, and it was poorly written and filled with cardboard characters that I couldnt care less about. Virtually everyone in this book was either a psychopath who blithely committed murder or a cynic who moved through life with hardly any redeeming qualities',5,'Childhood Restored',4,4),
    (33, 'The audiobook is narrated by a full cast of characters - which usually does more to confuse me than nrich the book. I liked that before speaking, most of the narrators character and that the book is formatted as a mash-up of interviews rather than just dialog and description.',5,'What a Read',6,4),
    (34, 'I fell in love with this book, my all time favorite. thank you',5,'lets Explore',8,4),
    (35, 'his was a very dark and intense reading experience for me. It has a dystopian, hypnotic quality to it. It is a book that needs to be pulled apart and talked about and analysed. Everything that happens in this book can be seen from many different angles and you may change your mind several times about which of the characters are the ones to be feared. A good choice if you are looking for something introspective that will leave you thinking.',5,'journey is amazing app',10,4),
    (36, 'I fell in love with this book, my all time favorite. thank you',5,'Fell in love',12,4),
    (37, 'I fell in love with this book, my all time favorite. thank you',5,'Mind is amazing',14,4),
    (38, 'Al I need was a little wine and this is awesome book. I have nothing but love.',15,'Wine and Read',16,4),
    (39, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',18,4),
    (40, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',20,4),
    (41, 'She works for the FBI in the 1980s and finds herself pulled into an intelligence operation to bring down a West African leader. Marie has her own agenda, too, and she has an interest in learning more about the man behind this operation, who has a connection to her sisters death.',5,'LOVE!!!',1,5),
    (42, 'I fell in love with this book, my all time favorite. thank you',5,'Childhood Restored',3,5),
    (43, 'Im finding this a hard review to put into words. Reminiscent of a Stephen King book at times, especially The Dome, this was enjoyable without too much craziness.',5,'What a Read',5,5),
    (44, 'I fell in love with this book, my all time favorite. thank you',5,'lets Explore',7,5),
    (45, 'The audiobook is narrated by a full cast of characters - which usually does more to confuse me than enrich the book. I liked that before speaking, most of the narrators stated the name of their character and that the book is formatted as a mash-up of interviews rather than just dialog and description.',5,'journey is amazing app',8,5),
    (46, 'I fell in love with this book, my all time favorite. thank you',5,'Fell in love',11,5),
    (47, 'I fell in love with this book, my all time favorite. thank you',5,'Mind is amazing',13,5),
    (48, 'Al I need was a little wine and this is awesome book. I have nothing but love.',15,'Wine and Read',15,5),
    (49, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',17,5),
    (50, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',19,5),
    (51, 'his was a very dark and intense reading experience for me. It has a dystopian, hypnotic quality to it. It is a book that needs to be pulled apart and talked about and analysed. Everything that happens in this book can be seen from many different angles and you may change your mind several times about which of the characters are the ones to be feared. A good choice if you are looking for something introspective that will leave you thinking.. thank you',5,'LOVE!!!',30,6),
    (52, 'I fell in love with this book, my all time favorite. thank you',5,'Childhood Restored',28,6),
    (53, 'Im finding this a hard review to put into words. Reminiscent of a Stephen King book at times, especially The Dome, this was enjoyable without too much craziness.',5,'What a Read',26,6),
    (54, 'This book felt like talking to an old friend who just gets you. I recommend it to anyone who struggles with anxiety or fears of loss, death',5,'lets Explore',24,6),
    (55, 'Karen Russell is one of my favorite writers around today. While I enjoyed all of her word choices Karen Russell is one of my favorite writers around today. While I enjoyed all of her word choices ',5,'journey is amazing app',22,6),
    (56, 'I fell in love with this book, my all time favorite. thank you',5,'Fell in love',20,6),
    (57, 'Terrific book - a slow start but then you grow to love the characters…',5,'Mind is amazing',18,6),
    (58, 'Al I need was a little wine and this is awesome book. I have nothing but love.',15,'Wine and Read',16,6),
    (59, 'Simple times for simple love stories. I wish I knew this sooner.',4,'Simple Times when reading',14,6),
    (60, 'When I was reading i am not sure what i was thinking when i read this store.',2,'I am not sure',12,6);




-- Inserting genres
INSERT INTO GENRE (NAME) VALUES ('Science Fiction');
INSERT INTO GENRE (NAME) VALUES ('Mystery');
INSERT INTO GENRE (NAME) VALUES ('Romance');
INSERT INTO GENRE (NAME) VALUES ('Fantasy');
INSERT INTO GENRE (NAME) VALUES ('Thriller');
INSERT INTO GENRE (NAME) VALUES ('Action');
INSERT INTO GENRE (NAME) VALUES ('Drama');
INSERT INTO GENRE (NAME) VALUES ('Comedy');
INSERT INTO GENRE (NAME) VALUES ('Horror');
INSERT INTO GENRE (NAME) VALUES ('Historical Fiction');
INSERT INTO GENRE (NAME) VALUES ('Adventure');
INSERT INTO GENRE (NAME) VALUES ('Crime');
INSERT INTO GENRE (NAME) VALUES ('Suspense');
INSERT INTO GENRE (NAME) VALUES ('Western');
INSERT INTO GENRE (NAME) VALUES ('Espionage');
INSERT INTO GENRE (NAME) VALUES ('Supernatural');
INSERT INTO GENRE (NAME) VALUES ('War');
INSERT INTO GENRE (NAME) VALUES ('Non-fiction');
INSERT INTO GENRE (NAME) VALUES ('Biography');
INSERT INTO GENRE (NAME) VALUES ('Autobiography');
INSERT INTO GENRE (NAME) VALUES ('Memoir');
INSERT INTO GENRE (NAME) VALUES ('Fantasy Adventure');
INSERT INTO GENRE (NAME) VALUES ('Sci-Fi Fantasy');
INSERT INTO GENRE (NAME) VALUES ('Cyberpunk');
INSERT INTO GENRE (NAME) VALUES ('Dystopian');
INSERT INTO GENRE (NAME) VALUES ('Post-Apocalyptic');
INSERT INTO GENRE (NAME) VALUES ('Steampunk');
INSERT INTO GENRE (NAME) VALUES ('Urban Fantasy');
INSERT INTO GENRE (NAME) VALUES ('Magical Realism');
INSERT INTO GENRE (NAME) VALUES ('Historical Romance');
INSERT INTO GENRE (NAME) VALUES ('Paranormal Romance');
INSERT INTO GENRE (NAME) VALUES ('Chick Lit');
INSERT INTO GENRE (NAME) VALUES ('Satire');
INSERT INTO GENRE (NAME) VALUES ('Tragedy');
INSERT INTO GENRE (NAME) VALUES ('Comedy-Drama');
INSERT INTO GENRE (NAME) VALUES ('Dark Comedy');
INSERT INTO GENRE (NAME) VALUES ('Slice of Life');
INSERT INTO GENRE (NAME) VALUES ('Coming of Age');
INSERT INTO GENRE (NAME) VALUES ('Epic');
INSERT INTO GENRE (NAME) VALUES ('Mythology');
INSERT INTO GENRE (NAME) VALUES ('Religious');
INSERT INTO GENRE (NAME) VALUES ('Inspirational');
INSERT INTO GENRE (NAME) VALUES ('Self-help');
INSERT INTO GENRE (NAME) VALUES ('Philosophy');
INSERT INTO GENRE (NAME) VALUES ('Psychology');
INSERT INTO GENRE (NAME) VALUES ('Sociology');
INSERT INTO GENRE (NAME) VALUES ('Economics');
INSERT INTO GENRE (NAME) VALUES ('Political');
INSERT INTO GENRE (NAME) VALUES ('Science');
INSERT INTO GENRE (NAME) VALUES ('Technology');
INSERT INTO GENRE (NAME) VALUES ('Mathematics');
INSERT INTO GENRE (NAME) VALUES ('History');
INSERT INTO GENRE (NAME) VALUES ('Art');
INSERT INTO GENRE (NAME) VALUES ('Music');
INSERT INTO GENRE (NAME) VALUES ('Film');
INSERT INTO GENRE (NAME) VALUES ('Theater');
INSERT INTO GENRE (NAME) VALUES ('Poetry');
INSERT INTO GENRE (NAME) VALUES ('Short Story');
INSERT INTO GENRE (NAME) VALUES ('Novella');
INSERT INTO GENRE (NAME) VALUES ('Graphic Novel');
INSERT INTO GENRE (NAME) VALUES ('Manga');
INSERT INTO GENRE (NAME) VALUES ('Comic Book');
INSERT INTO GENRE (NAME) VALUES ('Children''s');
INSERT INTO GENRE (NAME) VALUES ('Middle-Grade');
INSERT INTO GENRE (NAME) VALUES ('Young Adult');
INSERT INTO GENRE (NAME) VALUES ('New Adult');
INSERT INTO GENRE (NAME) VALUES ('Adult Fiction');
INSERT INTO GENRE (NAME) VALUES ('Adult Non-fiction');


-- Associating users with genres
-- Bobby likes Science Fiction, Mystery, Romance, Action, Historical Fiction
INSERT INTO FAVORITE_GENRE (USER_ID, GENRE_ID) VALUES
    (1, 1), -- Science Fiction
    (1, 2), -- Mystery
    (1, 3), -- Romance
    (1, 6), -- Action
    (1, 9); -- Historical Fiction

-- Lucy likes Romance, Fantasy, Drama, Comedy
INSERT INTO FAVORITE_GENRE (USER_ID, GENRE_ID) VALUES
    (2, 3),  -- Romance
    (2, 4),  -- Fantasy
    (2, 7),  -- Drama
    (2, 8);  -- Comedy

-- Chris likes Mystery, Comedy
INSERT INTO FAVORITE_GENRE (USER_ID, GENRE_ID) VALUES
    (3, 2),  -- Mystery
    (3, 8);  -- Comedy

-- Peter likes Fantasy, Thriller, Action, Horror
INSERT INTO FAVORITE_GENRE (USER_ID, GENRE_ID) VALUES
    (4, 4),  -- Fantasy
    (4, 5),  -- Thriller
    (4, 6),  -- Action
    (4, 10); -- Horror

-- Lance likes Science Fiction, Fantasy, Drama, Historical Fiction
INSERT INTO FAVORITE_GENRE (USER_ID, GENRE_ID) VALUES
    (5, 1),  -- Science Fiction
    (5, 4),  -- Fantasy
    (5, 7),  -- Drama
    (5, 9);  -- Historical Fiction



