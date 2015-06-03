package com.calclab.core.constants;

import java.math.BigDecimal;

public final class MathConstants {

	/**
	 * The base of the natural logarithm in a predefined accuracy.
	 * http://www.cs.arizona.edu/icon/oddsends/e.htm
	 * The precision of the predefined constant is one less than
	 * the string's length, taking into account the decimal dot.
	 */
	public static final BigDecimal E = new BigDecimal(
			"2.71828182845904523536028747135266249775724709369995957496696762772407663035354" +
					"759457138217852516642742746639193200305992181741359662904357290033429526059563" +
					"073813232862794349076323382988075319525101901157383418793070215408914993488416" +
					"750924476146066808226480016847741185374234544243710753907774499206955170276183" +
					"860626133138458300075204493382656029760673711320070932870912744374704723069697" +
					"720931014169283681902551510865746377211125238978442505695369677078544996996794" +
					"686445490598793163688923009879312773617821542499922957635148220826989519366803" +
					"318252886939849646510582093923982948879332036250944311730123819706841614039701" +
					"983767932068328237646480429531180232878250981945581530175671736133206981125099" +
					"618188159304169035159888851934580727386673858942287922849989208680582574927961" +
					"048419844436346324496848756023362482704197862320900216099023530436994184914631" +
					"409343173814364054625315209618369088870701676839642437814059271456354906130310" +
					"720851038375051011574770417189861068739696552126715468895703503540212340784981" +
					"933432106817012100562788023519303322474501585390473041995777709350366041699732" +
					"972508868769664035557071622684471625607988265178713419512466520103059212366771" +
					"943252786753985589448969709640975459185695638023637016211204774272283648961342" +
					"251644507818244235294863637214174023889344124796357437026375529444833799801612" +
					"549227850925778256209262264832627793338656648162772516401910590049164499828931");

	/**
	 * Euler's constant Pi.
	 * http://www.cs.arizona.edu/icon/oddsends/pi.htm
	 */
	public static final BigDecimal PI = new BigDecimal(
			"3.14159265358979323846264338327950288419716939937510582097494459230781640628620" +
					"899862803482534211706798214808651328230664709384460955058223172535940812848111" +
					"745028410270193852110555964462294895493038196442881097566593344612847564823378" +
					"678316527120190914564856692346034861045432664821339360726024914127372458700660" +
					"631558817488152092096282925409171536436789259036001133053054882046652138414695" +
					"194151160943305727036575959195309218611738193261179310511854807446237996274956" +
					"735188575272489122793818301194912983367336244065664308602139494639522473719070" +
					"217986094370277053921717629317675238467481846766940513200056812714526356082778" +
					"577134275778960917363717872146844090122495343014654958537105079227968925892354" +
					"201995611212902196086403441815981362977477130996051870721134999999837297804995" +
					"105973173281609631859502445945534690830264252230825334468503526193118817101000" +
					"313783875288658753320838142061717766914730359825349042875546873115956286388235" +
					"378759375195778185778053217122680661300192787661119590921642019893809525720106" +
					"548586327886593615338182796823030195203530185296899577362259941389124972177528" +
					"347913151557485724245415069595082953311686172785588907509838175463746493931925" +
					"506040092770167113900984882401285836160356370766010471018194295559619894676783" +
					"744944825537977472684710404753464620804668425906949129331367702898915210475216" +
					"205696602405803815019351125338243003558764024749647326391419927260426992279678" +
					"235478163600934172164121992458631503028618297455570674983850549458858692699569" +
					"092721079750930295532116534498720275596023648066549911988183479775356636980742" +
					"654252786255181841757467289097777279380008164706001614524919217321721477235014");

	/**
	 * Euler-Mascheroni constant lower-case gamma.
	 * http://www.worldwideschool.org/library/books/sci/math/MiscellaneousMathematicalConstants/chap35.html
	 */
	public static final BigDecimal GAMMA = new BigDecimal(
			"0.577215664901532860606512090082402431042159335939923598805767234884867726777664670936" +
					"947063291746749514631447249807082480960504014486542836224173997644923536253500" +
					"333742937337737673942792595258247094916008735203948165670853233151776611528621" +
					"199501507984793745085705740029921354786146694029604325421519058775535267331399" +
					"254012967420513754139549111685102807984234877587205038431093997361372553060889" +
					"331267600172479537836759271351577226102734929139407984301034177717780881549570" +
					"661075010161916633401522789358679654972520362128792265559536696281763887927268" +
					"013243101047650596370394739495763890657296792960100901512519595092224350140934" +
					"987122824794974719564697631850667612906381105182419744486783638086174945516989" +
					"279230187739107294578155431600500218284409605377243420328547836701517739439870" +
					"030237033951832869000155819398804270741154222781971652301107356583396734871765" +
					"049194181230004065469314299929777956930310050308630341856980323108369164002589" +
					"297089098548682577736428825395492587362959613329857473930237343884707037028441" +
					"292016641785024873337908056275499843459076164316710314671072237002181074504441" +
					"866475913480366902553245862544222534518138791243457350136129778227828814894590" +
					"986384600629316947188714958752549236649352047324364109726827616087759508809512" +
					"620840454447799229915724829251625127842765965708321461029821461795195795909592" +
					"270420898962797125536321794887376421066060706598256199010288075612519913751167" +
					"82176436190570584407835735015800560774579342131449885007864151716151945");

	/**
	 * Natural logarithm of 2.
	 * http://www.worldwideschool.org/library/books/sci/math/MiscellaneousMathematicalConstants/chap58.html
	 */
	public static final BigDecimal LOG2 = new BigDecimal(
			"0.693147180559945309417232121458176568075500134360255254120680009493393621969694715605" +
					"863326996418687542001481020570685733685520235758130557032670751635075961930727" +
					"570828371435190307038623891673471123350115364497955239120475172681574932065155" +
					"524734139525882950453007095326366642654104239157814952043740430385500801944170" +
					"641671518644712839968171784546957026271631064546150257207402481637773389638550" +
					"695260668341137273873722928956493547025762652098859693201965058554764703306793" +
					"654432547632744951250406069438147104689946506220167720424524529612687946546193" +
					"165174681392672504103802546259656869144192871608293803172714367782654877566485" +
					"085674077648451464439940461422603193096735402574446070308096085047486638523138" +
					"181676751438667476647890881437141985494231519973548803751658612753529166100071" +
					"053558249879414729509293113897155998205654392871700072180857610252368892132449" +
					"713893203784393530887748259701715591070882368362758984258918535302436342143670" +
					"611892367891923723146723217205340164925687274778234453534764811494186423867767" +
					"744060695626573796008670762571991847340226514628379048830620330611446300737194" +
					"890027436439650025809365194430411911506080948793067865158870900605203468429736" +
					"193841289652556539686022194122924207574321757489097706752687115817051137009158" +
					"942665478595964890653058460258668382940022833005382074005677053046787001841624" +
					"044188332327983863490015631218895606505531512721993983320307514084260914790012" +
					"651682434438935724727882054862715527418772430024897945401961872339808608316648" +
					"114909306675193393128904316413706813977764981769748689038877899912965036192707" +
					"10889264105230924783917373501229842420499568935992206602204654941510613");

}
