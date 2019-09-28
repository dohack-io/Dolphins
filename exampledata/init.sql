-- Benutzer --
INSERT INTO benutzer (anzeigename, adminstrator, email, passwort, realname)
VALUES ('autofahrer', false, 'autofahrer@aol.de', 'qwert', 'Joachim Maier');

INSERT INTO benutzer (anzeigename, adminstrator, email, passwort, realname)
VALUES ('ninayildiz', false, 'n.yildiz@gmx.de', 'nina', 'Nina Yildiz');

INSERT INTO benutzer (anzeigename, adminstrator, email, passwort, realname)
VALUES ('StadtDO', false, 'stadt@dortmund.de', 'dortmund', 'Stadt Dortmund');

INSERT INTO benutzer (anzeigename, adminstrator, email, passwort, realname)
VALUES ('BezirksvertretungEving', false, 'bv.eving@dortmund.de', 'dortmund', 'Bezirksvertretung Eving');


-- Dokument --
INSERT INTO dokument (drucksachennr, beschreibung, erstell_datum, dateipfad, titel, autor)
VALUES ('1', 'Die Stadt Dortmund hat sich mit der Parkpreis-Lage beschäftigt und schlägt eine Erhöhung dieser vor',
 '2018-11-08 08:49', '/home/river/Dokumente/Arbeit/Dolphins/Dokumente/StadtDO/Parkpreise.txt', 'Parkpreisanpassungen in Dortmund', 'StadtDO');

INSERT INTO dokument (drucksachennr, beschreibung, erstell_datum, dateipfad, titel, autor)
VALUES ('2', 'Es werden 5 Straßen im Stadtteil Brechten gewidmet',
 '2019-09-27 11:42', '/home/river/Dokumente/Arbeit/Dolphins/Dokumente/BezirksvertretungEving/WidmungBrechtenerStraßen.txt', 'Widmung Brechtener Straßen', 'BezirksvertretungEving');



