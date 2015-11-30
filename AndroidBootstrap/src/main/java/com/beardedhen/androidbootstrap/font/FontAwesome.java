package com.beardedhen.androidbootstrap.font;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/**
 * Maps FontAwesome Icon Codes to unicode characters, allowing its use in AwesomeTextView.
 * See the <a href="http://fortawesome.github.io/Font-Awesome/cheatsheet/">Cheatsheet</a> for icon
 * code reference. <b>Please note that icon codes use underscores rather than hyphens in this
 * library.</b> For example, "fa-play" would become "fa_play". This is due to restrictions in how
 * Android Attributes can be named.
 */
public class FontAwesome implements IconSet {

    public static final String FONT_PATH = "fontawesome-webfont-v450.ttf";

    @Override public CharSequence unicodeForKey(@Icon CharSequence key) {
        return ICON_MAP.get(key);
    }

    @Override public CharSequence iconCodeForAttrIndex(int index) {
        return ATTR_MAP.get(index);
    }

    @Override public CharSequence fontPath() {
        return FONT_PATH;
    }

    // Auto-generated Icon Set from 2015-10-05

    private static final Map<String, String> ICON_MAP = new HashMap<>();
    private static final Map<Integer, String> ATTR_MAP = new HashMap<>();

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            FA_ADJUST,
            FA_ADN,
            FA_ALIGN_CENTER,
            FA_ALIGN_JUSTIFY,
            FA_ALIGN_LEFT,
            FA_ALIGN_RIGHT,
            FA_AMAZON,
            FA_AMBULANCE,
            FA_ANCHOR,
            FA_ANDROID,
            FA_ANGELLIST,
            FA_ANGLE_DOUBLE_DOWN,
            FA_ANGLE_DOUBLE_LEFT,
            FA_ANGLE_DOUBLE_RIGHT,
            FA_ANGLE_DOUBLE_UP,
            FA_ANGLE_DOWN,
            FA_ANGLE_LEFT,
            FA_ANGLE_RIGHT,
            FA_ANGLE_UP,
            FA_APPLE,
            FA_ARCHIVE,
            FA_AREA_CHART,
            FA_ARROW_CIRCLE_DOWN,
            FA_ARROW_CIRCLE_LEFT,
            FA_ARROW_CIRCLE_O_DOWN,
            FA_ARROW_CIRCLE_O_LEFT,
            FA_ARROW_CIRCLE_O_RIGHT,
            FA_ARROW_CIRCLE_O_UP,
            FA_ARROW_CIRCLE_RIGHT,
            FA_ARROW_CIRCLE_UP,
            FA_ARROW_DOWN,
            FA_ARROW_LEFT,
            FA_ARROW_RIGHT,
            FA_ARROW_UP,
            FA_ARROWS,
            FA_ARROWS_ALT,
            FA_ARROWS_H,
            FA_ARROWS_V,
            FA_ASTERISK,
            FA_AT,
            FA_AUTOMOBILE,
            FA_BACKWARD,
            FA_BALANCE_SCALE,
            FA_BAN,
            FA_BANK,
            FA_BAR_CHART,
            FA_BAR_CHART_O,
            FA_BARCODE,
            FA_BARS,
            FA_BATTERY_0,
            FA_BATTERY_1,
            FA_BATTERY_2,
            FA_BATTERY_3,
            FA_BATTERY_4,
            FA_BATTERY_EMPTY,
            FA_BATTERY_FULL,
            FA_BATTERY_HALF,
            FA_BATTERY_QUARTER,
            FA_BATTERY_THREE_QUARTERS,
            FA_BED,
            FA_BEER,
            FA_BEHANCE,
            FA_BEHANCE_SQUARE,
            FA_BELL,
            FA_BELL_O,
            FA_BELL_SLASH,
            FA_BELL_SLASH_O,
            FA_BICYCLE,
            FA_BINOCULARS,
            FA_BIRTHDAY_CAKE,
            FA_BITBUCKET,
            FA_BITBUCKET_SQUARE,
            FA_BITCOIN,
            FA_BLACK_TIE,
            FA_BLUETOOTH,
            FA_BLUETOOTH_B,
            FA_BOLD,
            FA_BOLT,
            FA_BOMB,
            FA_BOOK,
            FA_BOOKMARK,
            FA_BOOKMARK_O,
            FA_BRIEFCASE,
            FA_BTC,
            FA_BUG,
            FA_BUILDING,
            FA_BUILDING_O,
            FA_BULLHORN,
            FA_BULLSEYE,
            FA_BUS,
            FA_BUYSELLADS,
            FA_CAB,
            FA_CALCULATOR,
            FA_CALENDAR,
            FA_CALENDAR_CHECK_O,
            FA_CALENDAR_MINUS_O,
            FA_CALENDAR_O,
            FA_CALENDAR_PLUS_O,
            FA_CALENDAR_TIMES_O,
            FA_CAMERA,
            FA_CAMERA_RETRO,
            FA_CAR,
            FA_CARET_DOWN,
            FA_CARET_LEFT,
            FA_CARET_RIGHT,
            FA_CARET_SQUARE_O_DOWN,
            FA_CARET_SQUARE_O_LEFT,
            FA_CARET_SQUARE_O_RIGHT,
            FA_CARET_SQUARE_O_UP,
            FA_CARET_UP,
            FA_CART_ARROW_DOWN,
            FA_CART_PLUS,
            FA_CC,
            FA_CC_AMEX,
            FA_CC_DINERS_CLUB,
            FA_CC_DISCOVER,
            FA_CC_JCB,
            FA_CC_MASTERCARD,
            FA_CC_PAYPAL,
            FA_CC_STRIPE,
            FA_CC_VISA,
            FA_CERTIFICATE,
            FA_CHAIN,
            FA_CHAIN_BROKEN,
            FA_CHECK,
            FA_CHECK_CIRCLE,
            FA_CHECK_CIRCLE_O,
            FA_CHECK_SQUARE,
            FA_CHECK_SQUARE_O,
            FA_CHEVRON_CIRCLE_DOWN,
            FA_CHEVRON_CIRCLE_LEFT,
            FA_CHEVRON_CIRCLE_RIGHT,
            FA_CHEVRON_CIRCLE_UP,
            FA_CHEVRON_DOWN,
            FA_CHEVRON_LEFT,
            FA_CHEVRON_RIGHT,
            FA_CHEVRON_UP,
            FA_CHILD,
            FA_CHROME,
            FA_CIRCLE,
            FA_CIRCLE_O,
            FA_CIRCLE_O_NOTCH,
            FA_CIRCLE_THIN,
            FA_CLIPBOARD,
            FA_CLOCK_O,
            FA_CLONE,
            FA_CLOSE,
            FA_CLOUD,
            FA_CLOUD_DOWNLOAD,
            FA_CLOUD_UPLOAD,
            FA_CNY,
            FA_CODE,
            FA_CODE_FORK,
            FA_CODEPEN,
            FA_CODIEPIE,
            FA_COFFEE,
            FA_COG,
            FA_COGS,
            FA_COLUMNS,
            FA_COMMENT,
            FA_COMMENT_O,
            FA_COMMENTING,
            FA_COMMENTING_O,
            FA_COMMENTS,
            FA_COMMENTS_O,
            FA_COMPASS,
            FA_COMPRESS,
            FA_CONNECTDEVELOP,
            FA_CONTAO,
            FA_COPY,
            FA_COPYRIGHT,
            FA_CREATIVE_COMMONS,
            FA_CREDIT_CARD,
            FA_CREDIT_CARD_ALT,
            FA_CROP,
            FA_CROSSHAIRS,
            FA_CSS3,
            FA_CUBE,
            FA_CUBES,
            FA_CUT,
            FA_CUTLERY,
            FA_DASHBOARD,
            FA_DASHCUBE,
            FA_DATABASE,
            FA_DEDENT,
            FA_DELICIOUS,
            FA_DESKTOP,
            FA_DEVIANTART,
            FA_DIAMOND,
            FA_DIGG,
            FA_DOLLAR,
            FA_DOT_CIRCLE_O,
            FA_DOWNLOAD,
            FA_DRIBBBLE,
            FA_DROPBOX,
            FA_DRUPAL,
            FA_EDGE,
            FA_EDIT,
            FA_EJECT,
            FA_ELLIPSIS_H,
            FA_ELLIPSIS_V,
            FA_EMPIRE,
            FA_ENVELOPE,
            FA_ENVELOPE_O,
            FA_ENVELOPE_SQUARE,
            FA_ERASER,
            FA_EUR,
            FA_EURO,
            FA_EXCHANGE,
            FA_EXCLAMATION,
            FA_EXCLAMATION_CIRCLE,
            FA_EXCLAMATION_TRIANGLE,
            FA_EXPAND,
            FA_EXPEDITEDSSL,
            FA_EXTERNAL_LINK,
            FA_EXTERNAL_LINK_SQUARE,
            FA_EYE,
            FA_EYE_SLASH,
            FA_EYEDROPPER,
            FA_FACEBOOK,
            FA_FACEBOOK_F,
            FA_FACEBOOK_OFFICIAL,
            FA_FACEBOOK_SQUARE,
            FA_FAST_BACKWARD,
            FA_FAST_FORWARD,
            FA_FAX,
            FA_FEED,
            FA_FEMALE,
            FA_FIGHTER_JET,
            FA_FILE,
            FA_FILE_ARCHIVE_O,
            FA_FILE_AUDIO_O,
            FA_FILE_CODE_O,
            FA_FILE_EXCEL_O,
            FA_FILE_IMAGE_O,
            FA_FILE_MOVIE_O,
            FA_FILE_O,
            FA_FILE_PDF_O,
            FA_FILE_PHOTO_O,
            FA_FILE_PICTURE_O,
            FA_FILE_POWERPOINT_O,
            FA_FILE_SOUND_O,
            FA_FILE_TEXT,
            FA_FILE_TEXT_O,
            FA_FILE_VIDEO_O,
            FA_FILE_WORD_O,
            FA_FILE_ZIP_O,
            FA_FILES_O,
            FA_FILM,
            FA_FILTER,
            FA_FIRE,
            FA_FIRE_EXTINGUISHER,
            FA_FIREFOX,
            FA_FLAG,
            FA_FLAG_CHECKERED,
            FA_FLAG_O,
            FA_FLASH,
            FA_FLASK,
            FA_FLICKR,
            FA_FLOPPY_O,
            FA_FOLDER,
            FA_FOLDER_O,
            FA_FOLDER_OPEN,
            FA_FOLDER_OPEN_O,
            FA_FONT,
            FA_FONTICONS,
            FA_FORT_AWESOME,
            FA_FORUMBEE,
            FA_FORWARD,
            FA_FOURSQUARE,
            FA_FROWN_O,
            FA_FUTBOL_O,
            FA_GAMEPAD,
            FA_GAVEL,
            FA_GBP,
            FA_GE,
            FA_GEAR,
            FA_GEARS,
            FA_GENDERLESS,
            FA_GET_POCKET,
            FA_GG,
            FA_GG_CIRCLE,
            FA_GIFT,
            FA_GIT,
            FA_GIT_SQUARE,
            FA_GITHUB,
            FA_GITHUB_ALT,
            FA_GITHUB_SQUARE,
            FA_GITTIP,
            FA_GLASS,
            FA_GLOBE,
            FA_GOOGLE,
            FA_GOOGLE_PLUS,
            FA_GOOGLE_PLUS_SQUARE,
            FA_GOOGLE_WALLET,
            FA_GRADUATION_CAP,
            FA_GRATIPAY,
            FA_GROUP,
            FA_H_SQUARE,
            FA_HACKER_NEWS,
            FA_HAND_GRAB_O,
            FA_HAND_LIZARD_O,
            FA_HAND_O_DOWN,
            FA_HAND_O_LEFT,
            FA_HAND_O_RIGHT,
            FA_HAND_O_UP,
            FA_HAND_PAPER_O,
            FA_HAND_PEACE_O,
            FA_HAND_POINTER_O,
            FA_HAND_ROCK_O,
            FA_HAND_SCISSORS_O,
            FA_HAND_SPOCK_O,
            FA_HAND_STOP_O,
            FA_HASHTAG,
            FA_HDD_O,
            FA_HEADER,
            FA_HEADPHONES,
            FA_HEART,
            FA_HEART_O,
            FA_HEARTBEAT,
            FA_HISTORY,
            FA_HOME,
            FA_HOSPITAL_O,
            FA_HOTEL,
            FA_HOURGLASS,
            FA_HOURGLASS_1,
            FA_HOURGLASS_2,
            FA_HOURGLASS_3,
            FA_HOURGLASS_END,
            FA_HOURGLASS_HALF,
            FA_HOURGLASS_O,
            FA_HOURGLASS_START,
            FA_HOUZZ,
            FA_HTML5,
            FA_I_CURSOR,
            FA_ILS,
            FA_IMAGE,
            FA_INBOX,
            FA_INDENT,
            FA_INDUSTRY,
            FA_INFO,
            FA_INFO_CIRCLE,
            FA_INR,
            FA_INSTAGRAM,
            FA_INSTITUTION,
            FA_INTERNET_EXPLORER,
            FA_INTERSEX,
            FA_IOXHOST,
            FA_ITALIC,
            FA_JOOMLA,
            FA_JPY,
            FA_JSFIDDLE,
            FA_KEY,
            FA_KEYBOARD_O,
            FA_KRW,
            FA_LANGUAGE,
            FA_LAPTOP,
            FA_LASTFM,
            FA_LASTFM_SQUARE,
            FA_LEAF,
            FA_LEANPUB,
            FA_LEGAL,
            FA_LEMON_O,
            FA_LEVEL_DOWN,
            FA_LEVEL_UP,
            FA_LIFE_BOUY,
            FA_LIFE_BUOY,
            FA_LIFE_RING,
            FA_LIFE_SAVER,
            FA_LIGHTBULB_O,
            FA_LINE_CHART,
            FA_LINK,
            FA_LINKEDIN,
            FA_LINKEDIN_SQUARE,
            FA_LINUX,
            FA_LIST,
            FA_LIST_ALT,
            FA_LIST_OL,
            FA_LIST_UL,
            FA_LOCATION_ARROW,
            FA_LOCK,
            FA_LONG_ARROW_DOWN,
            FA_LONG_ARROW_LEFT,
            FA_LONG_ARROW_RIGHT,
            FA_LONG_ARROW_UP,
            FA_MAGIC,
            FA_MAGNET,
            FA_MAIL_FORWARD,
            FA_MAIL_REPLY,
            FA_MAIL_REPLY_ALL,
            FA_MALE,
            FA_MAP,
            FA_MAP_MARKER,
            FA_MAP_O,
            FA_MAP_PIN,
            FA_MAP_SIGNS,
            FA_MARS,
            FA_MARS_DOUBLE,
            FA_MARS_STROKE,
            FA_MARS_STROKE_H,
            FA_MARS_STROKE_V,
            FA_MAXCDN,
            FA_MEANPATH,
            FA_MEDIUM,
            FA_MEDKIT,
            FA_MEH_O,
            FA_MERCURY,
            FA_MICROPHONE,
            FA_MICROPHONE_SLASH,
            FA_MINUS,
            FA_MINUS_CIRCLE,
            FA_MINUS_SQUARE,
            FA_MINUS_SQUARE_O,
            FA_MIXCLOUD,
            FA_MOBILE,
            FA_MOBILE_PHONE,
            FA_MODX,
            FA_MONEY,
            FA_MOON_O,
            FA_MORTAR_BOARD,
            FA_MOTORCYCLE,
            FA_MOUSE_POINTER,
            FA_MUSIC,
            FA_NAVICON,
            FA_NEUTER,
            FA_NEWSPAPER_O,
            FA_OBJECT_GROUP,
            FA_OBJECT_UNGROUP,
            FA_ODNOKLASSNIKI,
            FA_ODNOKLASSNIKI_SQUARE,
            FA_OPENCART,
            FA_OPENID,
            FA_OPERA,
            FA_OPTIN_MONSTER,
            FA_OUTDENT,
            FA_PAGELINES,
            FA_PAINT_BRUSH,
            FA_PAPER_PLANE,
            FA_PAPER_PLANE_O,
            FA_PAPERCLIP,
            FA_PARAGRAPH,
            FA_PASTE,
            FA_PAUSE,
            FA_PAUSE_CIRCLE,
            FA_PAUSE_CIRCLE_O,
            FA_PAW,
            FA_PAYPAL,
            FA_PENCIL,
            FA_PENCIL_SQUARE,
            FA_PENCIL_SQUARE_O,
            FA_PERCENT,
            FA_PHONE,
            FA_PHONE_SQUARE,
            FA_PHOTO,
            FA_PICTURE_O,
            FA_PIE_CHART,
            FA_PIED_PIPER,
            FA_PIED_PIPER_ALT,
            FA_PINTEREST,
            FA_PINTEREST_P,
            FA_PINTEREST_SQUARE,
            FA_PLANE,
            FA_PLAY,
            FA_PLAY_CIRCLE,
            FA_PLAY_CIRCLE_O,
            FA_PLUG,
            FA_PLUS,
            FA_PLUS_CIRCLE,
            FA_PLUS_SQUARE,
            FA_PLUS_SQUARE_O,
            FA_POWER_OFF,
            FA_PRINT,
            FA_PRODUCT_HUNT,
            FA_PUZZLE_PIECE,
            FA_QQ,
            FA_QRCODE,
            FA_QUESTION,
            FA_QUESTION_CIRCLE,
            FA_QUOTE_LEFT,
            FA_QUOTE_RIGHT,
            FA_RA,
            FA_RANDOM,
            FA_REBEL,
            FA_RECYCLE,
            FA_REDDIT,
            FA_REDDIT_ALIEN,
            FA_REDDIT_SQUARE,
            FA_REFRESH,
            FA_REGISTERED,
            FA_REMOVE,
            FA_RENREN,
            FA_REORDER,
            FA_REPEAT,
            FA_REPLY,
            FA_REPLY_ALL,
            FA_RETWEET,
            FA_RMB,
            FA_ROAD,
            FA_ROCKET,
            FA_ROTATE_LEFT,
            FA_ROTATE_RIGHT,
            FA_ROUBLE,
            FA_RSS,
            FA_RSS_SQUARE,
            FA_RUB,
            FA_RUBLE,
            FA_RUPEE,
            FA_SAFARI,
            FA_SAVE,
            FA_SCISSORS,
            FA_SCRIBD,
            FA_SEARCH,
            FA_SEARCH_MINUS,
            FA_SEARCH_PLUS,
            FA_SELLSY,
            FA_SEND,
            FA_SEND_O,
            FA_SERVER,
            FA_SHARE,
            FA_SHARE_ALT,
            FA_SHARE_ALT_SQUARE,
            FA_SHARE_SQUARE,
            FA_SHARE_SQUARE_O,
            FA_SHEKEL,
            FA_SHEQEL,
            FA_SHIELD,
            FA_SHIP,
            FA_SHIRTSINBULK,
            FA_SHOPPING_BAG,
            FA_SHOPPING_BASKET,
            FA_SHOPPING_CART,
            FA_SIGN_IN,
            FA_SIGN_OUT,
            FA_SIGNAL,
            FA_SIMPLYBUILT,
            FA_SITEMAP,
            FA_SKYATLAS,
            FA_SKYPE,
            FA_SLACK,
            FA_SLIDERS,
            FA_SLIDESHARE,
            FA_SMILE_O,
            FA_SOCCER_BALL_O,
            FA_SORT,
            FA_SORT_ALPHA_ASC,
            FA_SORT_ALPHA_DESC,
            FA_SORT_AMOUNT_ASC,
            FA_SORT_AMOUNT_DESC,
            FA_SORT_ASC,
            FA_SORT_DESC,
            FA_SORT_DOWN,
            FA_SORT_NUMERIC_ASC,
            FA_SORT_NUMERIC_DESC,
            FA_SORT_UP,
            FA_SOUNDCLOUD,
            FA_SPACE_SHUTTLE,
            FA_SPINNER,
            FA_SPOON,
            FA_SPOTIFY,
            FA_SQUARE,
            FA_SQUARE_O,
            FA_STACK_EXCHANGE,
            FA_STACK_OVERFLOW,
            FA_STAR,
            FA_STAR_HALF,
            FA_STAR_HALF_EMPTY,
            FA_STAR_HALF_FULL,
            FA_STAR_HALF_O,
            FA_STAR_O,
            FA_STEAM,
            FA_STEAM_SQUARE,
            FA_STEP_BACKWARD,
            FA_STEP_FORWARD,
            FA_STETHOSCOPE,
            FA_STICKY_NOTE,
            FA_STICKY_NOTE_O,
            FA_STOP,
            FA_STOP_CIRCLE,
            FA_STOP_CIRCLE_O,
            FA_STREET_VIEW,
            FA_STRIKETHROUGH,
            FA_STUMBLEUPON,
            FA_STUMBLEUPON_CIRCLE,
            FA_SUBSCRIPT,
            FA_SUBWAY,
            FA_SUITCASE,
            FA_SUN_O,
            FA_SUPERSCRIPT,
            FA_SUPPORT,
            FA_TABLE,
            FA_TABLET,
            FA_TACHOMETER,
            FA_TAG,
            FA_TAGS,
            FA_TASKS,
            FA_TAXI,
            FA_TELEVISION,
            FA_TENCENT_WEIBO,
            FA_TERMINAL,
            FA_TEXT_HEIGHT,
            FA_TEXT_WIDTH,
            FA_TH,
            FA_TH_LARGE,
            FA_TH_LIST,
            FA_THUMB_TACK,
            FA_THUMBS_DOWN,
            FA_THUMBS_O_DOWN,
            FA_THUMBS_O_UP,
            FA_THUMBS_UP,
            FA_TICKET,
            FA_TIMES,
            FA_TIMES_CIRCLE,
            FA_TIMES_CIRCLE_O,
            FA_TINT,
            FA_TOGGLE_DOWN,
            FA_TOGGLE_LEFT,
            FA_TOGGLE_OFF,
            FA_TOGGLE_ON,
            FA_TOGGLE_RIGHT,
            FA_TOGGLE_UP,
            FA_TRADEMARK,
            FA_TRAIN,
            FA_TRANSGENDER,
            FA_TRANSGENDER_ALT,
            FA_TRASH,
            FA_TRASH_O,
            FA_TREE,
            FA_TRELLO,
            FA_TRIPADVISOR,
            FA_TROPHY,
            FA_TRUCK,
            FA_TRY,
            FA_TTY,
            FA_TUMBLR,
            FA_TUMBLR_SQUARE,
            FA_TURKISH_LIRA,
            FA_TV,
            FA_TWITCH,
            FA_TWITTER,
            FA_TWITTER_SQUARE,
            FA_UMBRELLA,
            FA_UNDERLINE,
            FA_UNDO,
            FA_UNIVERSITY,
            FA_UNLINK,
            FA_UNLOCK,
            FA_UNLOCK_ALT,
            FA_UNSORTED,
            FA_UPLOAD,
            FA_USB,
            FA_USD,
            FA_USER,
            FA_USER_MD,
            FA_USER_PLUS,
            FA_USER_SECRET,
            FA_USER_TIMES,
            FA_USERS,
            FA_VENUS,
            FA_VENUS_DOUBLE,
            FA_VENUS_MARS,
            FA_VIACOIN,
            FA_VIDEO_CAMERA,
            FA_VIMEO,
            FA_VIMEO_SQUARE,
            FA_VINE,
            FA_VK,
            FA_VOLUME_DOWN,
            FA_VOLUME_OFF,
            FA_VOLUME_UP,
            FA_WARNING,
            FA_WECHAT,
            FA_WEIBO,
            FA_WEIXIN,
            FA_WHATSAPP,
            FA_WHEELCHAIR,
            FA_WIFI,
            FA_WIKIPEDIA_W,
            FA_WINDOWS,
            FA_WON,
            FA_WORDPRESS,
            FA_WRENCH,
            FA_XING,
            FA_XING_SQUARE,
            FA_Y_COMBINATOR,
            FA_Y_COMBINATOR_SQUARE,
            FA_YAHOO,
            FA_YC,
            FA_YC_SQUARE,
            FA_YELP,
            FA_YEN,
            FA_YOUTUBE,
            FA_YOUTUBE_PLAY,
            FA_YOUTUBE_SQUARE
    }) public @interface Icon {
    }

    public static final String FA_ADJUST = "fa_adjust";
    public static final String FA_ADN = "fa_adn";
    public static final String FA_ALIGN_CENTER = "fa_align_center";
    public static final String FA_ALIGN_JUSTIFY = "fa_align_justify";
    public static final String FA_ALIGN_LEFT = "fa_align_left";
    public static final String FA_ALIGN_RIGHT = "fa_align_right";
    public static final String FA_AMAZON = "fa_amazon";
    public static final String FA_AMBULANCE = "fa_ambulance";
    public static final String FA_ANCHOR = "fa_anchor";
    public static final String FA_ANDROID = "fa_android";
    public static final String FA_ANGELLIST = "fa_angellist";
    public static final String FA_ANGLE_DOUBLE_DOWN = "fa_angle_double_down";
    public static final String FA_ANGLE_DOUBLE_LEFT = "fa_angle_double_left";
    public static final String FA_ANGLE_DOUBLE_RIGHT = "fa_angle_double_right";
    public static final String FA_ANGLE_DOUBLE_UP = "fa_angle_double_up";
    public static final String FA_ANGLE_DOWN = "fa_angle_down";
    public static final String FA_ANGLE_LEFT = "fa_angle_left";
    public static final String FA_ANGLE_RIGHT = "fa_angle_right";
    public static final String FA_ANGLE_UP = "fa_angle_up";
    public static final String FA_APPLE = "fa_apple";
    public static final String FA_ARCHIVE = "fa_archive";
    public static final String FA_AREA_CHART = "fa_area_chart";
    public static final String FA_ARROW_CIRCLE_DOWN = "fa_arrow_circle_down";
    public static final String FA_ARROW_CIRCLE_LEFT = "fa_arrow_circle_left";
    public static final String FA_ARROW_CIRCLE_O_DOWN = "fa_arrow_circle_o_down";
    public static final String FA_ARROW_CIRCLE_O_LEFT = "fa_arrow_circle_o_left";
    public static final String FA_ARROW_CIRCLE_O_RIGHT = "fa_arrow_circle_o_right";
    public static final String FA_ARROW_CIRCLE_O_UP = "fa_arrow_circle_o_up";
    public static final String FA_ARROW_CIRCLE_RIGHT = "fa_arrow_circle_right";
    public static final String FA_ARROW_CIRCLE_UP = "fa_arrow_circle_up";
    public static final String FA_ARROW_DOWN = "fa_arrow_down";
    public static final String FA_ARROW_LEFT = "fa_arrow_left";
    public static final String FA_ARROW_RIGHT = "fa_arrow_right";
    public static final String FA_ARROW_UP = "fa_arrow_up";
    public static final String FA_ARROWS = "fa_arrows";
    public static final String FA_ARROWS_ALT = "fa_arrows_alt";
    public static final String FA_ARROWS_H = "fa_arrows_h";
    public static final String FA_ARROWS_V = "fa_arrows_v";
    public static final String FA_ASTERISK = "fa_asterisk";
    public static final String FA_AT = "fa_at";
    public static final String FA_AUTOMOBILE = "fa_automobile";
    public static final String FA_BACKWARD = "fa_backward";
    public static final String FA_BALANCE_SCALE = "fa_balance_scale";
    public static final String FA_BAN = "fa_ban";
    public static final String FA_BANK = "fa_bank";
    public static final String FA_BAR_CHART = "fa_bar_chart";
    public static final String FA_BAR_CHART_O = "fa_bar_chart_o";
    public static final String FA_BARCODE = "fa_barcode";
    public static final String FA_BARS = "fa_bars";
    public static final String FA_BATTERY_0 = "fa_battery_0";
    public static final String FA_BATTERY_1 = "fa_battery_1";
    public static final String FA_BATTERY_2 = "fa_battery_2";
    public static final String FA_BATTERY_3 = "fa_battery_3";
    public static final String FA_BATTERY_4 = "fa_battery_4";
    public static final String FA_BATTERY_EMPTY = "fa_battery_empty";
    public static final String FA_BATTERY_FULL = "fa_battery_full";
    public static final String FA_BATTERY_HALF = "fa_battery_half";
    public static final String FA_BATTERY_QUARTER = "fa_battery_quarter";
    public static final String FA_BATTERY_THREE_QUARTERS = "fa_battery_three_quarters";
    public static final String FA_BED = "fa_bed";
    public static final String FA_BEER = "fa_beer";
    public static final String FA_BEHANCE = "fa_behance";
    public static final String FA_BEHANCE_SQUARE = "fa_behance_square";
    public static final String FA_BELL = "fa_bell";
    public static final String FA_BELL_O = "fa_bell_o";
    public static final String FA_BELL_SLASH = "fa_bell_slash";
    public static final String FA_BELL_SLASH_O = "fa_bell_slash_o";
    public static final String FA_BICYCLE = "fa_bicycle";
    public static final String FA_BINOCULARS = "fa_binoculars";
    public static final String FA_BIRTHDAY_CAKE = "fa_birthday_cake";
    public static final String FA_BITBUCKET = "fa_bitbucket";
    public static final String FA_BITBUCKET_SQUARE = "fa_bitbucket_square";
    public static final String FA_BITCOIN = "fa_bitcoin";
    public static final String FA_BLACK_TIE = "fa_black_tie";
    public static final String FA_BLUETOOTH = "fa_bluetooth";
    public static final String FA_BLUETOOTH_B = "fa_bluetooth_b";
    public static final String FA_BOLD = "fa_bold";
    public static final String FA_BOLT = "fa_bolt";
    public static final String FA_BOMB = "fa_bomb";
    public static final String FA_BOOK = "fa_book";
    public static final String FA_BOOKMARK = "fa_bookmark";
    public static final String FA_BOOKMARK_O = "fa_bookmark_o";
    public static final String FA_BRIEFCASE = "fa_briefcase";
    public static final String FA_BTC = "fa_btc";
    public static final String FA_BUG = "fa_bug";
    public static final String FA_BUILDING = "fa_building";
    public static final String FA_BUILDING_O = "fa_building_o";
    public static final String FA_BULLHORN = "fa_bullhorn";
    public static final String FA_BULLSEYE = "fa_bullseye";
    public static final String FA_BUS = "fa_bus";
    public static final String FA_BUYSELLADS = "fa_buysellads";
    public static final String FA_CAB = "fa_cab";
    public static final String FA_CALCULATOR = "fa_calculator";
    public static final String FA_CALENDAR = "fa_calendar";
    public static final String FA_CALENDAR_CHECK_O = "fa_calendar_check_o";
    public static final String FA_CALENDAR_MINUS_O = "fa_calendar_minus_o";
    public static final String FA_CALENDAR_O = "fa_calendar_o";
    public static final String FA_CALENDAR_PLUS_O = "fa_calendar_plus_o";
    public static final String FA_CALENDAR_TIMES_O = "fa_calendar_times_o";
    public static final String FA_CAMERA = "fa_camera";
    public static final String FA_CAMERA_RETRO = "fa_camera_retro";
    public static final String FA_CAR = "fa_car";
    public static final String FA_CARET_DOWN = "fa_caret_down";
    public static final String FA_CARET_LEFT = "fa_caret_left";
    public static final String FA_CARET_RIGHT = "fa_caret_right";
    public static final String FA_CARET_SQUARE_O_DOWN = "fa_caret_square_o_down";
    public static final String FA_CARET_SQUARE_O_LEFT = "fa_caret_square_o_left";
    public static final String FA_CARET_SQUARE_O_RIGHT = "fa_caret_square_o_right";
    public static final String FA_CARET_SQUARE_O_UP = "fa_caret_square_o_up";
    public static final String FA_CARET_UP = "fa_caret_up";
    public static final String FA_CART_ARROW_DOWN = "fa_cart_arrow_down";
    public static final String FA_CART_PLUS = "fa_cart_plus";
    public static final String FA_CC = "fa_cc";
    public static final String FA_CC_AMEX = "fa_cc_amex";
    public static final String FA_CC_DINERS_CLUB = "fa_cc_diners_club";
    public static final String FA_CC_DISCOVER = "fa_cc_discover";
    public static final String FA_CC_JCB = "fa_cc_jcb";
    public static final String FA_CC_MASTERCARD = "fa_cc_mastercard";
    public static final String FA_CC_PAYPAL = "fa_cc_paypal";
    public static final String FA_CC_STRIPE = "fa_cc_stripe";
    public static final String FA_CC_VISA = "fa_cc_visa";
    public static final String FA_CERTIFICATE = "fa_certificate";
    public static final String FA_CHAIN = "fa_chain";
    public static final String FA_CHAIN_BROKEN = "fa_chain_broken";
    public static final String FA_CHECK = "fa_check";
    public static final String FA_CHECK_CIRCLE = "fa_check_circle";
    public static final String FA_CHECK_CIRCLE_O = "fa_check_circle_o";
    public static final String FA_CHECK_SQUARE = "fa_check_square";
    public static final String FA_CHECK_SQUARE_O = "fa_check_square_o";
    public static final String FA_CHEVRON_CIRCLE_DOWN = "fa_chevron_circle_down";
    public static final String FA_CHEVRON_CIRCLE_LEFT = "fa_chevron_circle_left";
    public static final String FA_CHEVRON_CIRCLE_RIGHT = "fa_chevron_circle_right";
    public static final String FA_CHEVRON_CIRCLE_UP = "fa_chevron_circle_up";
    public static final String FA_CHEVRON_DOWN = "fa_chevron_down";
    public static final String FA_CHEVRON_LEFT = "fa_chevron_left";
    public static final String FA_CHEVRON_RIGHT = "fa_chevron_right";
    public static final String FA_CHEVRON_UP = "fa_chevron_up";
    public static final String FA_CHILD = "fa_child";
    public static final String FA_CHROME = "fa_chrome";
    public static final String FA_CIRCLE = "fa_circle";
    public static final String FA_CIRCLE_O = "fa_circle_o";
    public static final String FA_CIRCLE_O_NOTCH = "fa_circle_o_notch";
    public static final String FA_CIRCLE_THIN = "fa_circle_thin";
    public static final String FA_CLIPBOARD = "fa_clipboard";
    public static final String FA_CLOCK_O = "fa_clock_o";
    public static final String FA_CLONE = "fa_clone";
    public static final String FA_CLOSE = "fa_close";
    public static final String FA_CLOUD = "fa_cloud";
    public static final String FA_CLOUD_DOWNLOAD = "fa_cloud_download";
    public static final String FA_CLOUD_UPLOAD = "fa_cloud_upload";
    public static final String FA_CNY = "fa_cny";
    public static final String FA_CODE = "fa_code";
    public static final String FA_CODE_FORK = "fa_code_fork";
    public static final String FA_CODEPEN = "fa_codepen";
    public static final String FA_CODIEPIE = "fa_codiepie";
    public static final String FA_COFFEE = "fa_coffee";
    public static final String FA_COG = "fa_cog";
    public static final String FA_COGS = "fa_cogs";
    public static final String FA_COLUMNS = "fa_columns";
    public static final String FA_COMMENT = "fa_comment";
    public static final String FA_COMMENT_O = "fa_comment_o";
    public static final String FA_COMMENTING = "fa_commenting";
    public static final String FA_COMMENTING_O = "fa_commenting_o";
    public static final String FA_COMMENTS = "fa_comments";
    public static final String FA_COMMENTS_O = "fa_comments_o";
    public static final String FA_COMPASS = "fa_compass";
    public static final String FA_COMPRESS = "fa_compress";
    public static final String FA_CONNECTDEVELOP = "fa_connectdevelop";
    public static final String FA_CONTAO = "fa_contao";
    public static final String FA_COPY = "fa_copy";
    public static final String FA_COPYRIGHT = "fa_copyright";
    public static final String FA_CREATIVE_COMMONS = "fa_creative_commons";
    public static final String FA_CREDIT_CARD = "fa_credit_card";
    public static final String FA_CREDIT_CARD_ALT = "fa_credit_card_alt";
    public static final String FA_CROP = "fa_crop";
    public static final String FA_CROSSHAIRS = "fa_crosshairs";
    public static final String FA_CSS3 = "fa_css3";
    public static final String FA_CUBE = "fa_cube";
    public static final String FA_CUBES = "fa_cubes";
    public static final String FA_CUT = "fa_cut";
    public static final String FA_CUTLERY = "fa_cutlery";
    public static final String FA_DASHBOARD = "fa_dashboard";
    public static final String FA_DASHCUBE = "fa_dashcube";
    public static final String FA_DATABASE = "fa_database";
    public static final String FA_DEDENT = "fa_dedent";
    public static final String FA_DELICIOUS = "fa_delicious";
    public static final String FA_DESKTOP = "fa_desktop";
    public static final String FA_DEVIANTART = "fa_deviantart";
    public static final String FA_DIAMOND = "fa_diamond";
    public static final String FA_DIGG = "fa_digg";
    public static final String FA_DOLLAR = "fa_dollar";
    public static final String FA_DOT_CIRCLE_O = "fa_dot_circle_o";
    public static final String FA_DOWNLOAD = "fa_download";
    public static final String FA_DRIBBBLE = "fa_dribbble";
    public static final String FA_DROPBOX = "fa_dropbox";
    public static final String FA_DRUPAL = "fa_drupal";
    public static final String FA_EDGE = "fa_edge";
    public static final String FA_EDIT = "fa_edit";
    public static final String FA_EJECT = "fa_eject";
    public static final String FA_ELLIPSIS_H = "fa_ellipsis_h";
    public static final String FA_ELLIPSIS_V = "fa_ellipsis_v";
    public static final String FA_EMPIRE = "fa_empire";
    public static final String FA_ENVELOPE = "fa_envelope";
    public static final String FA_ENVELOPE_O = "fa_envelope_o";
    public static final String FA_ENVELOPE_SQUARE = "fa_envelope_square";
    public static final String FA_ERASER = "fa_eraser";
    public static final String FA_EUR = "fa_eur";
    public static final String FA_EURO = "fa_euro";
    public static final String FA_EXCHANGE = "fa_exchange";
    public static final String FA_EXCLAMATION = "fa_exclamation";
    public static final String FA_EXCLAMATION_CIRCLE = "fa_exclamation_circle";
    public static final String FA_EXCLAMATION_TRIANGLE = "fa_exclamation_triangle";
    public static final String FA_EXPAND = "fa_expand";
    public static final String FA_EXPEDITEDSSL = "fa_expeditedssl";
    public static final String FA_EXTERNAL_LINK = "fa_external_link";
    public static final String FA_EXTERNAL_LINK_SQUARE = "fa_external_link_square";
    public static final String FA_EYE = "fa_eye";
    public static final String FA_EYE_SLASH = "fa_eye_slash";
    public static final String FA_EYEDROPPER = "fa_eyedropper";
    public static final String FA_FACEBOOK = "fa_facebook";
    public static final String FA_FACEBOOK_F = "fa_facebook_f";
    public static final String FA_FACEBOOK_OFFICIAL = "fa_facebook_official";
    public static final String FA_FACEBOOK_SQUARE = "fa_facebook_square";
    public static final String FA_FAST_BACKWARD = "fa_fast_backward";
    public static final String FA_FAST_FORWARD = "fa_fast_forward";
    public static final String FA_FAX = "fa_fax";
    public static final String FA_FEED = "fa_feed";
    public static final String FA_FEMALE = "fa_female";
    public static final String FA_FIGHTER_JET = "fa_fighter_jet";
    public static final String FA_FILE = "fa_file";
    public static final String FA_FILE_ARCHIVE_O = "fa_file_archive_o";
    public static final String FA_FILE_AUDIO_O = "fa_file_audio_o";
    public static final String FA_FILE_CODE_O = "fa_file_code_o";
    public static final String FA_FILE_EXCEL_O = "fa_file_excel_o";
    public static final String FA_FILE_IMAGE_O = "fa_file_image_o";
    public static final String FA_FILE_MOVIE_O = "fa_file_movie_o";
    public static final String FA_FILE_O = "fa_file_o";
    public static final String FA_FILE_PDF_O = "fa_file_pdf_o";
    public static final String FA_FILE_PHOTO_O = "fa_file_photo_o";
    public static final String FA_FILE_PICTURE_O = "fa_file_picture_o";
    public static final String FA_FILE_POWERPOINT_O = "fa_file_powerpoint_o";
    public static final String FA_FILE_SOUND_O = "fa_file_sound_o";
    public static final String FA_FILE_TEXT = "fa_file_text";
    public static final String FA_FILE_TEXT_O = "fa_file_text_o";
    public static final String FA_FILE_VIDEO_O = "fa_file_video_o";
    public static final String FA_FILE_WORD_O = "fa_file_word_o";
    public static final String FA_FILE_ZIP_O = "fa_file_zip_o";
    public static final String FA_FILES_O = "fa_files_o";
    public static final String FA_FILM = "fa_film";
    public static final String FA_FILTER = "fa_filter";
    public static final String FA_FIRE = "fa_fire";
    public static final String FA_FIRE_EXTINGUISHER = "fa_fire_extinguisher";
    public static final String FA_FIREFOX = "fa_firefox";
    public static final String FA_FLAG = "fa_flag";
    public static final String FA_FLAG_CHECKERED = "fa_flag_checkered";
    public static final String FA_FLAG_O = "fa_flag_o";
    public static final String FA_FLASH = "fa_flash";
    public static final String FA_FLASK = "fa_flask";
    public static final String FA_FLICKR = "fa_flickr";
    public static final String FA_FLOPPY_O = "fa_floppy_o";
    public static final String FA_FOLDER = "fa_folder";
    public static final String FA_FOLDER_O = "fa_folder_o";
    public static final String FA_FOLDER_OPEN = "fa_folder_open";
    public static final String FA_FOLDER_OPEN_O = "fa_folder_open_o";
    public static final String FA_FONT = "fa_font";
    public static final String FA_FONTICONS = "fa_fonticons";
    public static final String FA_FORT_AWESOME = "fa_fort_awesome";
    public static final String FA_FORUMBEE = "fa_forumbee";
    public static final String FA_FORWARD = "fa_forward";
    public static final String FA_FOURSQUARE = "fa_foursquare";
    public static final String FA_FROWN_O = "fa_frown_o";
    public static final String FA_FUTBOL_O = "fa_futbol_o";
    public static final String FA_GAMEPAD = "fa_gamepad";
    public static final String FA_GAVEL = "fa_gavel";
    public static final String FA_GBP = "fa_gbp";
    public static final String FA_GE = "fa_ge";
    public static final String FA_GEAR = "fa_gear";
    public static final String FA_GEARS = "fa_gears";
    public static final String FA_GENDERLESS = "fa_genderless";
    public static final String FA_GET_POCKET = "fa_get_pocket";
    public static final String FA_GG = "fa_gg";
    public static final String FA_GG_CIRCLE = "fa_gg_circle";
    public static final String FA_GIFT = "fa_gift";
    public static final String FA_GIT = "fa_git";
    public static final String FA_GIT_SQUARE = "fa_git_square";
    public static final String FA_GITHUB = "fa_github";
    public static final String FA_GITHUB_ALT = "fa_github_alt";
    public static final String FA_GITHUB_SQUARE = "fa_github_square";
    public static final String FA_GITTIP = "fa_gittip";
    public static final String FA_GLASS = "fa_glass";
    public static final String FA_GLOBE = "fa_globe";
    public static final String FA_GOOGLE = "fa_google";
    public static final String FA_GOOGLE_PLUS = "fa_google_plus";
    public static final String FA_GOOGLE_PLUS_SQUARE = "fa_google_plus_square";
    public static final String FA_GOOGLE_WALLET = "fa_google_wallet";
    public static final String FA_GRADUATION_CAP = "fa_graduation_cap";
    public static final String FA_GRATIPAY = "fa_gratipay";
    public static final String FA_GROUP = "fa_group";
    public static final String FA_H_SQUARE = "fa_h_square";
    public static final String FA_HACKER_NEWS = "fa_hacker_news";
    public static final String FA_HAND_GRAB_O = "fa_hand_grab_o";
    public static final String FA_HAND_LIZARD_O = "fa_hand_lizard_o";
    public static final String FA_HAND_O_DOWN = "fa_hand_o_down";
    public static final String FA_HAND_O_LEFT = "fa_hand_o_left";
    public static final String FA_HAND_O_RIGHT = "fa_hand_o_right";
    public static final String FA_HAND_O_UP = "fa_hand_o_up";
    public static final String FA_HAND_PAPER_O = "fa_hand_paper_o";
    public static final String FA_HAND_PEACE_O = "fa_hand_peace_o";
    public static final String FA_HAND_POINTER_O = "fa_hand_pointer_o";
    public static final String FA_HAND_ROCK_O = "fa_hand_rock_o";
    public static final String FA_HAND_SCISSORS_O = "fa_hand_scissors_o";
    public static final String FA_HAND_SPOCK_O = "fa_hand_spock_o";
    public static final String FA_HAND_STOP_O = "fa_hand_stop_o";
    public static final String FA_HASHTAG = "fa_hashtag";
    public static final String FA_HDD_O = "fa_hdd_o";
    public static final String FA_HEADER = "fa_header";
    public static final String FA_HEADPHONES = "fa_headphones";
    public static final String FA_HEART = "fa_heart";
    public static final String FA_HEART_O = "fa_heart_o";
    public static final String FA_HEARTBEAT = "fa_heartbeat";
    public static final String FA_HISTORY = "fa_history";
    public static final String FA_HOME = "fa_home";
    public static final String FA_HOSPITAL_O = "fa_hospital_o";
    public static final String FA_HOTEL = "fa_hotel";
    public static final String FA_HOURGLASS = "fa_hourglass";
    public static final String FA_HOURGLASS_1 = "fa_hourglass_1";
    public static final String FA_HOURGLASS_2 = "fa_hourglass_2";
    public static final String FA_HOURGLASS_3 = "fa_hourglass_3";
    public static final String FA_HOURGLASS_END = "fa_hourglass_end";
    public static final String FA_HOURGLASS_HALF = "fa_hourglass_half";
    public static final String FA_HOURGLASS_O = "fa_hourglass_o";
    public static final String FA_HOURGLASS_START = "fa_hourglass_start";
    public static final String FA_HOUZZ = "fa_houzz";
    public static final String FA_HTML5 = "fa_html5";
    public static final String FA_I_CURSOR = "fa_i_cursor";
    public static final String FA_ILS = "fa_ils";
    public static final String FA_IMAGE = "fa_image";
    public static final String FA_INBOX = "fa_inbox";
    public static final String FA_INDENT = "fa_indent";
    public static final String FA_INDUSTRY = "fa_industry";
    public static final String FA_INFO = "fa_info";
    public static final String FA_INFO_CIRCLE = "fa_info_circle";
    public static final String FA_INR = "fa_inr";
    public static final String FA_INSTAGRAM = "fa_instagram";
    public static final String FA_INSTITUTION = "fa_institution";
    public static final String FA_INTERNET_EXPLORER = "fa_internet_explorer";
    public static final String FA_INTERSEX = "fa_intersex";
    public static final String FA_IOXHOST = "fa_ioxhost";
    public static final String FA_ITALIC = "fa_italic";
    public static final String FA_JOOMLA = "fa_joomla";
    public static final String FA_JPY = "fa_jpy";
    public static final String FA_JSFIDDLE = "fa_jsfiddle";
    public static final String FA_KEY = "fa_key";
    public static final String FA_KEYBOARD_O = "fa_keyboard_o";
    public static final String FA_KRW = "fa_krw";
    public static final String FA_LANGUAGE = "fa_language";
    public static final String FA_LAPTOP = "fa_laptop";
    public static final String FA_LASTFM = "fa_lastfm";
    public static final String FA_LASTFM_SQUARE = "fa_lastfm_square";
    public static final String FA_LEAF = "fa_leaf";
    public static final String FA_LEANPUB = "fa_leanpub";
    public static final String FA_LEGAL = "fa_legal";
    public static final String FA_LEMON_O = "fa_lemon_o";
    public static final String FA_LEVEL_DOWN = "fa_level_down";
    public static final String FA_LEVEL_UP = "fa_level_up";
    public static final String FA_LIFE_BOUY = "fa_life_bouy";
    public static final String FA_LIFE_BUOY = "fa_life_buoy";
    public static final String FA_LIFE_RING = "fa_life_ring";
    public static final String FA_LIFE_SAVER = "fa_life_saver";
    public static final String FA_LIGHTBULB_O = "fa_lightbulb_o";
    public static final String FA_LINE_CHART = "fa_line_chart";
    public static final String FA_LINK = "fa_link";
    public static final String FA_LINKEDIN = "fa_linkedin";
    public static final String FA_LINKEDIN_SQUARE = "fa_linkedin_square";
    public static final String FA_LINUX = "fa_linux";
    public static final String FA_LIST = "fa_list";
    public static final String FA_LIST_ALT = "fa_list_alt";
    public static final String FA_LIST_OL = "fa_list_ol";
    public static final String FA_LIST_UL = "fa_list_ul";
    public static final String FA_LOCATION_ARROW = "fa_location_arrow";
    public static final String FA_LOCK = "fa_lock";
    public static final String FA_LONG_ARROW_DOWN = "fa_long_arrow_down";
    public static final String FA_LONG_ARROW_LEFT = "fa_long_arrow_left";
    public static final String FA_LONG_ARROW_RIGHT = "fa_long_arrow_right";
    public static final String FA_LONG_ARROW_UP = "fa_long_arrow_up";
    public static final String FA_MAGIC = "fa_magic";
    public static final String FA_MAGNET = "fa_magnet";
    public static final String FA_MAIL_FORWARD = "fa_mail_forward";
    public static final String FA_MAIL_REPLY = "fa_mail_reply";
    public static final String FA_MAIL_REPLY_ALL = "fa_mail_reply_all";
    public static final String FA_MALE = "fa_male";
    public static final String FA_MAP = "fa_map";
    public static final String FA_MAP_MARKER = "fa_map_marker";
    public static final String FA_MAP_O = "fa_map_o";
    public static final String FA_MAP_PIN = "fa_map_pin";
    public static final String FA_MAP_SIGNS = "fa_map_signs";
    public static final String FA_MARS = "fa_mars";
    public static final String FA_MARS_DOUBLE = "fa_mars_double";
    public static final String FA_MARS_STROKE = "fa_mars_stroke";
    public static final String FA_MARS_STROKE_H = "fa_mars_stroke_h";
    public static final String FA_MARS_STROKE_V = "fa_mars_stroke_v";
    public static final String FA_MAXCDN = "fa_maxcdn";
    public static final String FA_MEANPATH = "fa_meanpath";
    public static final String FA_MEDIUM = "fa_medium";
    public static final String FA_MEDKIT = "fa_medkit";
    public static final String FA_MEH_O = "fa_meh_o";
    public static final String FA_MERCURY = "fa_mercury";
    public static final String FA_MICROPHONE = "fa_microphone";
    public static final String FA_MICROPHONE_SLASH = "fa_microphone_slash";
    public static final String FA_MINUS = "fa_minus";
    public static final String FA_MINUS_CIRCLE = "fa_minus_circle";
    public static final String FA_MINUS_SQUARE = "fa_minus_square";
    public static final String FA_MINUS_SQUARE_O = "fa_minus_square_o";
    public static final String FA_MIXCLOUD = "fa_mixcloud";
    public static final String FA_MOBILE = "fa_mobile";
    public static final String FA_MOBILE_PHONE = "fa_mobile_phone";
    public static final String FA_MODX = "fa_modx";
    public static final String FA_MONEY = "fa_money";
    public static final String FA_MOON_O = "fa_moon_o";
    public static final String FA_MORTAR_BOARD = "fa_mortar_board";
    public static final String FA_MOTORCYCLE = "fa_motorcycle";
    public static final String FA_MOUSE_POINTER = "fa_mouse_pointer";
    public static final String FA_MUSIC = "fa_music";
    public static final String FA_NAVICON = "fa_navicon";
    public static final String FA_NEUTER = "fa_neuter";
    public static final String FA_NEWSPAPER_O = "fa_newspaper_o";
    public static final String FA_OBJECT_GROUP = "fa_object_group";
    public static final String FA_OBJECT_UNGROUP = "fa_object_ungroup";
    public static final String FA_ODNOKLASSNIKI = "fa_odnoklassniki";
    public static final String FA_ODNOKLASSNIKI_SQUARE = "fa_odnoklassniki_square";
    public static final String FA_OPENCART = "fa_opencart";
    public static final String FA_OPENID = "fa_openid";
    public static final String FA_OPERA = "fa_opera";
    public static final String FA_OPTIN_MONSTER = "fa_optin_monster";
    public static final String FA_OUTDENT = "fa_outdent";
    public static final String FA_PAGELINES = "fa_pagelines";
    public static final String FA_PAINT_BRUSH = "fa_paint_brush";
    public static final String FA_PAPER_PLANE = "fa_paper_plane";
    public static final String FA_PAPER_PLANE_O = "fa_paper_plane_o";
    public static final String FA_PAPERCLIP = "fa_paperclip";
    public static final String FA_PARAGRAPH = "fa_paragraph";
    public static final String FA_PASTE = "fa_paste";
    public static final String FA_PAUSE = "fa_pause";
    public static final String FA_PAUSE_CIRCLE = "fa_pause_circle";
    public static final String FA_PAUSE_CIRCLE_O = "fa_pause_circle_o";
    public static final String FA_PAW = "fa_paw";
    public static final String FA_PAYPAL = "fa_paypal";
    public static final String FA_PENCIL = "fa_pencil";
    public static final String FA_PENCIL_SQUARE = "fa_pencil_square";
    public static final String FA_PENCIL_SQUARE_O = "fa_pencil_square_o";
    public static final String FA_PERCENT = "fa_percent";
    public static final String FA_PHONE = "fa_phone";
    public static final String FA_PHONE_SQUARE = "fa_phone_square";
    public static final String FA_PHOTO = "fa_photo";
    public static final String FA_PICTURE_O = "fa_picture_o";
    public static final String FA_PIE_CHART = "fa_pie_chart";
    public static final String FA_PIED_PIPER = "fa_pied_piper";
    public static final String FA_PIED_PIPER_ALT = "fa_pied_piper_alt";
    public static final String FA_PINTEREST = "fa_pinterest";
    public static final String FA_PINTEREST_P = "fa_pinterest_p";
    public static final String FA_PINTEREST_SQUARE = "fa_pinterest_square";
    public static final String FA_PLANE = "fa_plane";
    public static final String FA_PLAY = "fa_play";
    public static final String FA_PLAY_CIRCLE = "fa_play_circle";
    public static final String FA_PLAY_CIRCLE_O = "fa_play_circle_o";
    public static final String FA_PLUG = "fa_plug";
    public static final String FA_PLUS = "fa_plus";
    public static final String FA_PLUS_CIRCLE = "fa_plus_circle";
    public static final String FA_PLUS_SQUARE = "fa_plus_square";
    public static final String FA_PLUS_SQUARE_O = "fa_plus_square_o";
    public static final String FA_POWER_OFF = "fa_power_off";
    public static final String FA_PRINT = "fa_print";
    public static final String FA_PRODUCT_HUNT = "fa_product_hunt";
    public static final String FA_PUZZLE_PIECE = "fa_puzzle_piece";
    public static final String FA_QQ = "fa_qq";
    public static final String FA_QRCODE = "fa_qrcode";
    public static final String FA_QUESTION = "fa_question";
    public static final String FA_QUESTION_CIRCLE = "fa_question_circle";
    public static final String FA_QUOTE_LEFT = "fa_quote_left";
    public static final String FA_QUOTE_RIGHT = "fa_quote_right";
    public static final String FA_RA = "fa_ra";
    public static final String FA_RANDOM = "fa_random";
    public static final String FA_REBEL = "fa_rebel";
    public static final String FA_RECYCLE = "fa_recycle";
    public static final String FA_REDDIT = "fa_reddit";
    public static final String FA_REDDIT_ALIEN = "fa_reddit_alien";
    public static final String FA_REDDIT_SQUARE = "fa_reddit_square";
    public static final String FA_REFRESH = "fa_refresh";
    public static final String FA_REGISTERED = "fa_registered";
    public static final String FA_REMOVE = "fa_remove";
    public static final String FA_RENREN = "fa_renren";
    public static final String FA_REORDER = "fa_reorder";
    public static final String FA_REPEAT = "fa_repeat";
    public static final String FA_REPLY = "fa_reply";
    public static final String FA_REPLY_ALL = "fa_reply_all";
    public static final String FA_RETWEET = "fa_retweet";
    public static final String FA_RMB = "fa_rmb";
    public static final String FA_ROAD = "fa_road";
    public static final String FA_ROCKET = "fa_rocket";
    public static final String FA_ROTATE_LEFT = "fa_rotate_left";
    public static final String FA_ROTATE_RIGHT = "fa_rotate_right";
    public static final String FA_ROUBLE = "fa_rouble";
    public static final String FA_RSS = "fa_rss";
    public static final String FA_RSS_SQUARE = "fa_rss_square";
    public static final String FA_RUB = "fa_rub";
    public static final String FA_RUBLE = "fa_ruble";
    public static final String FA_RUPEE = "fa_rupee";
    public static final String FA_SAFARI = "fa_safari";
    public static final String FA_SAVE = "fa_save";
    public static final String FA_SCISSORS = "fa_scissors";
    public static final String FA_SCRIBD = "fa_scribd";
    public static final String FA_SEARCH = "fa_search";
    public static final String FA_SEARCH_MINUS = "fa_search_minus";
    public static final String FA_SEARCH_PLUS = "fa_search_plus";
    public static final String FA_SELLSY = "fa_sellsy";
    public static final String FA_SEND = "fa_send";
    public static final String FA_SEND_O = "fa_send_o";
    public static final String FA_SERVER = "fa_server";
    public static final String FA_SHARE = "fa_share";
    public static final String FA_SHARE_ALT = "fa_share_alt";
    public static final String FA_SHARE_ALT_SQUARE = "fa_share_alt_square";
    public static final String FA_SHARE_SQUARE = "fa_share_square";
    public static final String FA_SHARE_SQUARE_O = "fa_share_square_o";
    public static final String FA_SHEKEL = "fa_shekel";
    public static final String FA_SHEQEL = "fa_sheqel";
    public static final String FA_SHIELD = "fa_shield";
    public static final String FA_SHIP = "fa_ship";
    public static final String FA_SHIRTSINBULK = "fa_shirtsinbulk";
    public static final String FA_SHOPPING_BAG = "fa_shopping_bag";
    public static final String FA_SHOPPING_BASKET = "fa_shopping_basket";
    public static final String FA_SHOPPING_CART = "fa_shopping_cart";
    public static final String FA_SIGN_IN = "fa_sign_in";
    public static final String FA_SIGN_OUT = "fa_sign_out";
    public static final String FA_SIGNAL = "fa_signal";
    public static final String FA_SIMPLYBUILT = "fa_simplybuilt";
    public static final String FA_SITEMAP = "fa_sitemap";
    public static final String FA_SKYATLAS = "fa_skyatlas";
    public static final String FA_SKYPE = "fa_skype";
    public static final String FA_SLACK = "fa_slack";
    public static final String FA_SLIDERS = "fa_sliders";
    public static final String FA_SLIDESHARE = "fa_slideshare";
    public static final String FA_SMILE_O = "fa_smile_o";
    public static final String FA_SOCCER_BALL_O = "fa_soccer_ball_o";
    public static final String FA_SORT = "fa_sort";
    public static final String FA_SORT_ALPHA_ASC = "fa_sort_alpha_asc";
    public static final String FA_SORT_ALPHA_DESC = "fa_sort_alpha_desc";
    public static final String FA_SORT_AMOUNT_ASC = "fa_sort_amount_asc";
    public static final String FA_SORT_AMOUNT_DESC = "fa_sort_amount_desc";
    public static final String FA_SORT_ASC = "fa_sort_asc";
    public static final String FA_SORT_DESC = "fa_sort_desc";
    public static final String FA_SORT_DOWN = "fa_sort_down";
    public static final String FA_SORT_NUMERIC_ASC = "fa_sort_numeric_asc";
    public static final String FA_SORT_NUMERIC_DESC = "fa_sort_numeric_desc";
    public static final String FA_SORT_UP = "fa_sort_up";
    public static final String FA_SOUNDCLOUD = "fa_soundcloud";
    public static final String FA_SPACE_SHUTTLE = "fa_space_shuttle";
    public static final String FA_SPINNER = "fa_spinner";
    public static final String FA_SPOON = "fa_spoon";
    public static final String FA_SPOTIFY = "fa_spotify";
    public static final String FA_SQUARE = "fa_square";
    public static final String FA_SQUARE_O = "fa_square_o";
    public static final String FA_STACK_EXCHANGE = "fa_stack_exchange";
    public static final String FA_STACK_OVERFLOW = "fa_stack_overflow";
    public static final String FA_STAR = "fa_star";
    public static final String FA_STAR_HALF = "fa_star_half";
    public static final String FA_STAR_HALF_EMPTY = "fa_star_half_empty";
    public static final String FA_STAR_HALF_FULL = "fa_star_half_full";
    public static final String FA_STAR_HALF_O = "fa_star_half_o";
    public static final String FA_STAR_O = "fa_star_o";
    public static final String FA_STEAM = "fa_steam";
    public static final String FA_STEAM_SQUARE = "fa_steam_square";
    public static final String FA_STEP_BACKWARD = "fa_step_backward";
    public static final String FA_STEP_FORWARD = "fa_step_forward";
    public static final String FA_STETHOSCOPE = "fa_stethoscope";
    public static final String FA_STICKY_NOTE = "fa_sticky_note";
    public static final String FA_STICKY_NOTE_O = "fa_sticky_note_o";
    public static final String FA_STOP = "fa_stop";
    public static final String FA_STOP_CIRCLE = "fa_stop_circle";
    public static final String FA_STOP_CIRCLE_O = "fa_stop_circle_o";
    public static final String FA_STREET_VIEW = "fa_street_view";
    public static final String FA_STRIKETHROUGH = "fa_strikethrough";
    public static final String FA_STUMBLEUPON = "fa_stumbleupon";
    public static final String FA_STUMBLEUPON_CIRCLE = "fa_stumbleupon_circle";
    public static final String FA_SUBSCRIPT = "fa_subscript";
    public static final String FA_SUBWAY = "fa_subway";
    public static final String FA_SUITCASE = "fa_suitcase";
    public static final String FA_SUN_O = "fa_sun_o";
    public static final String FA_SUPERSCRIPT = "fa_superscript";
    public static final String FA_SUPPORT = "fa_support";
    public static final String FA_TABLE = "fa_table";
    public static final String FA_TABLET = "fa_tablet";
    public static final String FA_TACHOMETER = "fa_tachometer";
    public static final String FA_TAG = "fa_tag";
    public static final String FA_TAGS = "fa_tags";
    public static final String FA_TASKS = "fa_tasks";
    public static final String FA_TAXI = "fa_taxi";
    public static final String FA_TELEVISION = "fa_television";
    public static final String FA_TENCENT_WEIBO = "fa_tencent_weibo";
    public static final String FA_TERMINAL = "fa_terminal";
    public static final String FA_TEXT_HEIGHT = "fa_text_height";
    public static final String FA_TEXT_WIDTH = "fa_text_width";
    public static final String FA_TH = "fa_th";
    public static final String FA_TH_LARGE = "fa_th_large";
    public static final String FA_TH_LIST = "fa_th_list";
    public static final String FA_THUMB_TACK = "fa_thumb_tack";
    public static final String FA_THUMBS_DOWN = "fa_thumbs_down";
    public static final String FA_THUMBS_O_DOWN = "fa_thumbs_o_down";
    public static final String FA_THUMBS_O_UP = "fa_thumbs_o_up";
    public static final String FA_THUMBS_UP = "fa_thumbs_up";
    public static final String FA_TICKET = "fa_ticket";
    public static final String FA_TIMES = "fa_times";
    public static final String FA_TIMES_CIRCLE = "fa_times_circle";
    public static final String FA_TIMES_CIRCLE_O = "fa_times_circle_o";
    public static final String FA_TINT = "fa_tint";
    public static final String FA_TOGGLE_DOWN = "fa_toggle_down";
    public static final String FA_TOGGLE_LEFT = "fa_toggle_left";
    public static final String FA_TOGGLE_OFF = "fa_toggle_off";
    public static final String FA_TOGGLE_ON = "fa_toggle_on";
    public static final String FA_TOGGLE_RIGHT = "fa_toggle_right";
    public static final String FA_TOGGLE_UP = "fa_toggle_up";
    public static final String FA_TRADEMARK = "fa_trademark";
    public static final String FA_TRAIN = "fa_train";
    public static final String FA_TRANSGENDER = "fa_transgender";
    public static final String FA_TRANSGENDER_ALT = "fa_transgender_alt";
    public static final String FA_TRASH = "fa_trash";
    public static final String FA_TRASH_O = "fa_trash_o";
    public static final String FA_TREE = "fa_tree";
    public static final String FA_TRELLO = "fa_trello";
    public static final String FA_TRIPADVISOR = "fa_tripadvisor";
    public static final String FA_TROPHY = "fa_trophy";
    public static final String FA_TRUCK = "fa_truck";
    public static final String FA_TRY = "fa_try";
    public static final String FA_TTY = "fa_tty";
    public static final String FA_TUMBLR = "fa_tumblr";
    public static final String FA_TUMBLR_SQUARE = "fa_tumblr_square";
    public static final String FA_TURKISH_LIRA = "fa_turkish_lira";
    public static final String FA_TV = "fa_tv";
    public static final String FA_TWITCH = "fa_twitch";
    public static final String FA_TWITTER = "fa_twitter";
    public static final String FA_TWITTER_SQUARE = "fa_twitter_square";
    public static final String FA_UMBRELLA = "fa_umbrella";
    public static final String FA_UNDERLINE = "fa_underline";
    public static final String FA_UNDO = "fa_undo";
    public static final String FA_UNIVERSITY = "fa_university";
    public static final String FA_UNLINK = "fa_unlink";
    public static final String FA_UNLOCK = "fa_unlock";
    public static final String FA_UNLOCK_ALT = "fa_unlock_alt";
    public static final String FA_UNSORTED = "fa_unsorted";
    public static final String FA_UPLOAD = "fa_upload";
    public static final String FA_USB = "fa_usb";
    public static final String FA_USD = "fa_usd";
    public static final String FA_USER = "fa_user";
    public static final String FA_USER_MD = "fa_user_md";
    public static final String FA_USER_PLUS = "fa_user_plus";
    public static final String FA_USER_SECRET = "fa_user_secret";
    public static final String FA_USER_TIMES = "fa_user_times";
    public static final String FA_USERS = "fa_users";
    public static final String FA_VENUS = "fa_venus";
    public static final String FA_VENUS_DOUBLE = "fa_venus_double";
    public static final String FA_VENUS_MARS = "fa_venus_mars";
    public static final String FA_VIACOIN = "fa_viacoin";
    public static final String FA_VIDEO_CAMERA = "fa_video_camera";
    public static final String FA_VIMEO = "fa_vimeo";
    public static final String FA_VIMEO_SQUARE = "fa_vimeo_square";
    public static final String FA_VINE = "fa_vine";
    public static final String FA_VK = "fa_vk";
    public static final String FA_VOLUME_DOWN = "fa_volume_down";
    public static final String FA_VOLUME_OFF = "fa_volume_off";
    public static final String FA_VOLUME_UP = "fa_volume_up";
    public static final String FA_WARNING = "fa_warning";
    public static final String FA_WECHAT = "fa_wechat";
    public static final String FA_WEIBO = "fa_weibo";
    public static final String FA_WEIXIN = "fa_weixin";
    public static final String FA_WHATSAPP = "fa_whatsapp";
    public static final String FA_WHEELCHAIR = "fa_wheelchair";
    public static final String FA_WIFI = "fa_wifi";
    public static final String FA_WIKIPEDIA_W = "fa_wikipedia_w";
    public static final String FA_WINDOWS = "fa_windows";
    public static final String FA_WON = "fa_won";
    public static final String FA_WORDPRESS = "fa_wordpress";
    public static final String FA_WRENCH = "fa_wrench";
    public static final String FA_XING = "fa_xing";
    public static final String FA_XING_SQUARE = "fa_xing_square";
    public static final String FA_Y_COMBINATOR = "fa_y_combinator";
    public static final String FA_Y_COMBINATOR_SQUARE = "fa_y_combinator_square";
    public static final String FA_YAHOO = "fa_yahoo";
    public static final String FA_YC = "fa_yc";
    public static final String FA_YC_SQUARE = "fa_yc_square";
    public static final String FA_YELP = "fa_yelp";
    public static final String FA_YEN = "fa_yen";
    public static final String FA_YOUTUBE = "fa_youtube";
    public static final String FA_YOUTUBE_PLAY = "fa_youtube_play";
    public static final String FA_YOUTUBE_SQUARE = "fa_youtube_square";

    static {
        ICON_MAP.put(FA_ADJUST, "\uf042");
        ICON_MAP.put(FA_ADN, "\uf170");
        ICON_MAP.put(FA_ALIGN_CENTER, "\uf037");
        ICON_MAP.put(FA_ALIGN_JUSTIFY, "\uf039");
        ICON_MAP.put(FA_ALIGN_LEFT, "\uf036");
        ICON_MAP.put(FA_ALIGN_RIGHT, "\uf038");
        ICON_MAP.put(FA_AMAZON, "\uf270");
        ICON_MAP.put(FA_AMBULANCE, "\uf0f9");
        ICON_MAP.put(FA_ANCHOR, "\uf13d");
        ICON_MAP.put(FA_ANDROID, "\uf17b");
        ICON_MAP.put(FA_ANGELLIST, "\uf209");
        ICON_MAP.put(FA_ANGLE_DOUBLE_DOWN, "\uf103");
        ICON_MAP.put(FA_ANGLE_DOUBLE_LEFT, "\uf100");
        ICON_MAP.put(FA_ANGLE_DOUBLE_RIGHT, "\uf101");
        ICON_MAP.put(FA_ANGLE_DOUBLE_UP, "\uf102");
        ICON_MAP.put(FA_ANGLE_DOWN, "\uf107");
        ICON_MAP.put(FA_ANGLE_LEFT, "\uf104");
        ICON_MAP.put(FA_ANGLE_RIGHT, "\uf105");
        ICON_MAP.put(FA_ANGLE_UP, "\uf106");
        ICON_MAP.put(FA_APPLE, "\uf179");
        ICON_MAP.put(FA_ARCHIVE, "\uf187");
        ICON_MAP.put(FA_AREA_CHART, "\uf1fe");
        ICON_MAP.put(FA_ARROW_CIRCLE_DOWN, "\uf0ab");
        ICON_MAP.put(FA_ARROW_CIRCLE_LEFT, "\uf0a8");
        ICON_MAP.put(FA_ARROW_CIRCLE_O_DOWN, "\uf01a");
        ICON_MAP.put(FA_ARROW_CIRCLE_O_LEFT, "\uf190");
        ICON_MAP.put(FA_ARROW_CIRCLE_O_RIGHT, "\uf18e");
        ICON_MAP.put(FA_ARROW_CIRCLE_O_UP, "\uf01b");
        ICON_MAP.put(FA_ARROW_CIRCLE_RIGHT, "\uf0a9");
        ICON_MAP.put(FA_ARROW_CIRCLE_UP, "\uf0aa");
        ICON_MAP.put(FA_ARROW_DOWN, "\uf063");
        ICON_MAP.put(FA_ARROW_LEFT, "\uf060");
        ICON_MAP.put(FA_ARROW_RIGHT, "\uf061");
        ICON_MAP.put(FA_ARROW_UP, "\uf062");
        ICON_MAP.put(FA_ARROWS, "\uf047");
        ICON_MAP.put(FA_ARROWS_ALT, "\uf0b2");
        ICON_MAP.put(FA_ARROWS_H, "\uf07e");
        ICON_MAP.put(FA_ARROWS_V, "\uf07d");
        ICON_MAP.put(FA_ASTERISK, "\uf069");
        ICON_MAP.put(FA_AT, "\uf1fa");
        ICON_MAP.put(FA_AUTOMOBILE, "\uf1b9");
        ICON_MAP.put(FA_BACKWARD, "\uf04a");
        ICON_MAP.put(FA_BALANCE_SCALE, "\uf24e");
        ICON_MAP.put(FA_BAN, "\uf05e");
        ICON_MAP.put(FA_BANK, "\uf19c");
        ICON_MAP.put(FA_BAR_CHART, "\uf080");
        ICON_MAP.put(FA_BAR_CHART_O, "\uf080");
        ICON_MAP.put(FA_BARCODE, "\uf02a");
        ICON_MAP.put(FA_BARS, "\uf0c9");
        ICON_MAP.put(FA_BATTERY_0, "\uf244");
        ICON_MAP.put(FA_BATTERY_1, "\uf243");
        ICON_MAP.put(FA_BATTERY_2, "\uf242");
        ICON_MAP.put(FA_BATTERY_3, "\uf241");
        ICON_MAP.put(FA_BATTERY_4, "\uf240");
        ICON_MAP.put(FA_BATTERY_EMPTY, "\uf244");
        ICON_MAP.put(FA_BATTERY_FULL, "\uf240");
        ICON_MAP.put(FA_BATTERY_HALF, "\uf242");
        ICON_MAP.put(FA_BATTERY_QUARTER, "\uf243");
        ICON_MAP.put(FA_BATTERY_THREE_QUARTERS, "\uf241");
        ICON_MAP.put(FA_BED, "\uf236");
        ICON_MAP.put(FA_BEER, "\uf0fc");
        ICON_MAP.put(FA_BEHANCE, "\uf1b4");
        ICON_MAP.put(FA_BEHANCE_SQUARE, "\uf1b5");
        ICON_MAP.put(FA_BELL, "\uf0f3");
        ICON_MAP.put(FA_BELL_O, "\uf0a2");
        ICON_MAP.put(FA_BELL_SLASH, "\uf1f6");
        ICON_MAP.put(FA_BELL_SLASH_O, "\uf1f7");
        ICON_MAP.put(FA_BICYCLE, "\uf206");
        ICON_MAP.put(FA_BINOCULARS, "\uf1e5");
        ICON_MAP.put(FA_BIRTHDAY_CAKE, "\uf1fd");
        ICON_MAP.put(FA_BITBUCKET, "\uf171");
        ICON_MAP.put(FA_BITBUCKET_SQUARE, "\uf172");
        ICON_MAP.put(FA_BITCOIN, "\uf15a");
        ICON_MAP.put(FA_BLACK_TIE, "\uf27e");
        ICON_MAP.put(FA_BLUETOOTH, "\uf293");
        ICON_MAP.put(FA_BLUETOOTH_B, "\uf294");
        ICON_MAP.put(FA_BOLD, "\uf032");
        ICON_MAP.put(FA_BOLT, "\uf0e7");
        ICON_MAP.put(FA_BOMB, "\uf1e2");
        ICON_MAP.put(FA_BOOK, "\uf02d");
        ICON_MAP.put(FA_BOOKMARK, "\uf02e");
        ICON_MAP.put(FA_BOOKMARK_O, "\uf097");
        ICON_MAP.put(FA_BRIEFCASE, "\uf0b1");
        ICON_MAP.put(FA_BTC, "\uf15a");
        ICON_MAP.put(FA_BUG, "\uf188");
        ICON_MAP.put(FA_BUILDING, "\uf1ad");
        ICON_MAP.put(FA_BUILDING_O, "\uf0f7");
        ICON_MAP.put(FA_BULLHORN, "\uf0a1");
        ICON_MAP.put(FA_BULLSEYE, "\uf140");
        ICON_MAP.put(FA_BUS, "\uf207");
        ICON_MAP.put(FA_BUYSELLADS, "\uf20d");
        ICON_MAP.put(FA_CAB, "\uf1ba");
        ICON_MAP.put(FA_CALCULATOR, "\uf1ec");
        ICON_MAP.put(FA_CALENDAR, "\uf073");
        ICON_MAP.put(FA_CALENDAR_CHECK_O, "\uf274");
        ICON_MAP.put(FA_CALENDAR_MINUS_O, "\uf272");
        ICON_MAP.put(FA_CALENDAR_O, "\uf133");
        ICON_MAP.put(FA_CALENDAR_PLUS_O, "\uf271");
        ICON_MAP.put(FA_CALENDAR_TIMES_O, "\uf273");
        ICON_MAP.put(FA_CAMERA, "\uf030");
        ICON_MAP.put(FA_CAMERA_RETRO, "\uf083");
        ICON_MAP.put(FA_CAR, "\uf1b9");
        ICON_MAP.put(FA_CARET_DOWN, "\uf0d7");
        ICON_MAP.put(FA_CARET_LEFT, "\uf0d9");
        ICON_MAP.put(FA_CARET_RIGHT, "\uf0da");
        ICON_MAP.put(FA_CARET_SQUARE_O_DOWN, "\uf150");
        ICON_MAP.put(FA_CARET_SQUARE_O_LEFT, "\uf191");
        ICON_MAP.put(FA_CARET_SQUARE_O_RIGHT, "\uf152");
        ICON_MAP.put(FA_CARET_SQUARE_O_UP, "\uf151");
        ICON_MAP.put(FA_CARET_UP, "\uf0d8");
        ICON_MAP.put(FA_CART_ARROW_DOWN, "\uf218");
        ICON_MAP.put(FA_CART_PLUS, "\uf217");
        ICON_MAP.put(FA_CC, "\uf20a");
        ICON_MAP.put(FA_CC_AMEX, "\uf1f3");
        ICON_MAP.put(FA_CC_DINERS_CLUB, "\uf24c");
        ICON_MAP.put(FA_CC_DISCOVER, "\uf1f2");
        ICON_MAP.put(FA_CC_JCB, "\uf24b");
        ICON_MAP.put(FA_CC_MASTERCARD, "\uf1f1");
        ICON_MAP.put(FA_CC_PAYPAL, "\uf1f4");
        ICON_MAP.put(FA_CC_STRIPE, "\uf1f5");
        ICON_MAP.put(FA_CC_VISA, "\uf1f0");
        ICON_MAP.put(FA_CERTIFICATE, "\uf0a3");
        ICON_MAP.put(FA_CHAIN, "\uf0c1");
        ICON_MAP.put(FA_CHAIN_BROKEN, "\uf127");
        ICON_MAP.put(FA_CHECK, "\uf00c");
        ICON_MAP.put(FA_CHECK_CIRCLE, "\uf058");
        ICON_MAP.put(FA_CHECK_CIRCLE_O, "\uf05d");
        ICON_MAP.put(FA_CHECK_SQUARE, "\uf14a");
        ICON_MAP.put(FA_CHECK_SQUARE_O, "\uf046");
        ICON_MAP.put(FA_CHEVRON_CIRCLE_DOWN, "\uf13a");
        ICON_MAP.put(FA_CHEVRON_CIRCLE_LEFT, "\uf137");
        ICON_MAP.put(FA_CHEVRON_CIRCLE_RIGHT, "\uf138");
        ICON_MAP.put(FA_CHEVRON_CIRCLE_UP, "\uf139");
        ICON_MAP.put(FA_CHEVRON_DOWN, "\uf078");
        ICON_MAP.put(FA_CHEVRON_LEFT, "\uf053");
        ICON_MAP.put(FA_CHEVRON_RIGHT, "\uf054");
        ICON_MAP.put(FA_CHEVRON_UP, "\uf077");
        ICON_MAP.put(FA_CHILD, "\uf1ae");
        ICON_MAP.put(FA_CHROME, "\uf268");
        ICON_MAP.put(FA_CIRCLE, "\uf111");
        ICON_MAP.put(FA_CIRCLE_O, "\uf10c");
        ICON_MAP.put(FA_CIRCLE_O_NOTCH, "\uf1ce");
        ICON_MAP.put(FA_CIRCLE_THIN, "\uf1db");
        ICON_MAP.put(FA_CLIPBOARD, "\uf0ea");
        ICON_MAP.put(FA_CLOCK_O, "\uf017");
        ICON_MAP.put(FA_CLONE, "\uf24d");
        ICON_MAP.put(FA_CLOSE, "\uf00d");
        ICON_MAP.put(FA_CLOUD, "\uf0c2");
        ICON_MAP.put(FA_CLOUD_DOWNLOAD, "\uf0ed");
        ICON_MAP.put(FA_CLOUD_UPLOAD, "\uf0ee");
        ICON_MAP.put(FA_CNY, "\uf157");
        ICON_MAP.put(FA_CODE, "\uf121");
        ICON_MAP.put(FA_CODE_FORK, "\uf126");
        ICON_MAP.put(FA_CODEPEN, "\uf1cb");
        ICON_MAP.put(FA_CODIEPIE, "\uf284");
        ICON_MAP.put(FA_COFFEE, "\uf0f4");
        ICON_MAP.put(FA_COG, "\uf013");
        ICON_MAP.put(FA_COGS, "\uf085");
        ICON_MAP.put(FA_COLUMNS, "\uf0db");
        ICON_MAP.put(FA_COMMENT, "\uf075");
        ICON_MAP.put(FA_COMMENT_O, "\uf0e5");
        ICON_MAP.put(FA_COMMENTING, "\uf27a");
        ICON_MAP.put(FA_COMMENTING_O, "\uf27b");
        ICON_MAP.put(FA_COMMENTS, "\uf086");
        ICON_MAP.put(FA_COMMENTS_O, "\uf0e6");
        ICON_MAP.put(FA_COMPASS, "\uf14e");
        ICON_MAP.put(FA_COMPRESS, "\uf066");
        ICON_MAP.put(FA_CONNECTDEVELOP, "\uf20e");
        ICON_MAP.put(FA_CONTAO, "\uf26d");
        ICON_MAP.put(FA_COPY, "\uf0c5");
        ICON_MAP.put(FA_COPYRIGHT, "\uf1f9");
        ICON_MAP.put(FA_CREATIVE_COMMONS, "\uf25e");
        ICON_MAP.put(FA_CREDIT_CARD, "\uf09d");
        ICON_MAP.put(FA_CREDIT_CARD_ALT, "\uf283");
        ICON_MAP.put(FA_CROP, "\uf125");
        ICON_MAP.put(FA_CROSSHAIRS, "\uf05b");
        ICON_MAP.put(FA_CSS3, "\uf13c");
        ICON_MAP.put(FA_CUBE, "\uf1b2");
        ICON_MAP.put(FA_CUBES, "\uf1b3");
        ICON_MAP.put(FA_CUT, "\uf0c4");
        ICON_MAP.put(FA_CUTLERY, "\uf0f5");
        ICON_MAP.put(FA_DASHBOARD, "\uf0e4");
        ICON_MAP.put(FA_DASHCUBE, "\uf210");
        ICON_MAP.put(FA_DATABASE, "\uf1c0");
        ICON_MAP.put(FA_DEDENT, "\uf03b");
        ICON_MAP.put(FA_DELICIOUS, "\uf1a5");
        ICON_MAP.put(FA_DESKTOP, "\uf108");
        ICON_MAP.put(FA_DEVIANTART, "\uf1bd");
        ICON_MAP.put(FA_DIAMOND, "\uf219");
        ICON_MAP.put(FA_DIGG, "\uf1a6");
        ICON_MAP.put(FA_DOLLAR, "\uf155");
        ICON_MAP.put(FA_DOT_CIRCLE_O, "\uf192");
        ICON_MAP.put(FA_DOWNLOAD, "\uf019");
        ICON_MAP.put(FA_DRIBBBLE, "\uf17d");
        ICON_MAP.put(FA_DROPBOX, "\uf16b");
        ICON_MAP.put(FA_DRUPAL, "\uf1a9");
        ICON_MAP.put(FA_EDGE, "\uf282");
        ICON_MAP.put(FA_EDIT, "\uf044");
        ICON_MAP.put(FA_EJECT, "\uf052");
        ICON_MAP.put(FA_ELLIPSIS_H, "\uf141");
        ICON_MAP.put(FA_ELLIPSIS_V, "\uf142");
        ICON_MAP.put(FA_EMPIRE, "\uf1d1");
        ICON_MAP.put(FA_ENVELOPE, "\uf0e0");
        ICON_MAP.put(FA_ENVELOPE_O, "\uf003");
        ICON_MAP.put(FA_ENVELOPE_SQUARE, "\uf199");
        ICON_MAP.put(FA_ERASER, "\uf12d");
        ICON_MAP.put(FA_EUR, "\uf153");
        ICON_MAP.put(FA_EURO, "\uf153");
        ICON_MAP.put(FA_EXCHANGE, "\uf0ec");
        ICON_MAP.put(FA_EXCLAMATION, "\uf12a");
        ICON_MAP.put(FA_EXCLAMATION_CIRCLE, "\uf06a");
        ICON_MAP.put(FA_EXCLAMATION_TRIANGLE, "\uf071");
        ICON_MAP.put(FA_EXPAND, "\uf065");
        ICON_MAP.put(FA_EXPEDITEDSSL, "\uf23e");
        ICON_MAP.put(FA_EXTERNAL_LINK, "\uf08e");
        ICON_MAP.put(FA_EXTERNAL_LINK_SQUARE, "\uf14c");
        ICON_MAP.put(FA_EYE, "\uf06e");
        ICON_MAP.put(FA_EYE_SLASH, "\uf070");
        ICON_MAP.put(FA_EYEDROPPER, "\uf1fb");
        ICON_MAP.put(FA_FACEBOOK, "\uf09a");
        ICON_MAP.put(FA_FACEBOOK_F, "\uf09a");
        ICON_MAP.put(FA_FACEBOOK_OFFICIAL, "\uf230");
        ICON_MAP.put(FA_FACEBOOK_SQUARE, "\uf082");
        ICON_MAP.put(FA_FAST_BACKWARD, "\uf049");
        ICON_MAP.put(FA_FAST_FORWARD, "\uf050");
        ICON_MAP.put(FA_FAX, "\uf1ac");
        ICON_MAP.put(FA_FEED, "\uf09e");
        ICON_MAP.put(FA_FEMALE, "\uf182");
        ICON_MAP.put(FA_FIGHTER_JET, "\uf0fb");
        ICON_MAP.put(FA_FILE, "\uf15b");
        ICON_MAP.put(FA_FILE_ARCHIVE_O, "\uf1c6");
        ICON_MAP.put(FA_FILE_AUDIO_O, "\uf1c7");
        ICON_MAP.put(FA_FILE_CODE_O, "\uf1c9");
        ICON_MAP.put(FA_FILE_EXCEL_O, "\uf1c3");
        ICON_MAP.put(FA_FILE_IMAGE_O, "\uf1c5");
        ICON_MAP.put(FA_FILE_MOVIE_O, "\uf1c8");
        ICON_MAP.put(FA_FILE_O, "\uf016");
        ICON_MAP.put(FA_FILE_PDF_O, "\uf1c1");
        ICON_MAP.put(FA_FILE_PHOTO_O, "\uf1c5");
        ICON_MAP.put(FA_FILE_PICTURE_O, "\uf1c5");
        ICON_MAP.put(FA_FILE_POWERPOINT_O, "\uf1c4");
        ICON_MAP.put(FA_FILE_SOUND_O, "\uf1c7");
        ICON_MAP.put(FA_FILE_TEXT, "\uf15c");
        ICON_MAP.put(FA_FILE_TEXT_O, "\uf0f6");
        ICON_MAP.put(FA_FILE_VIDEO_O, "\uf1c8");
        ICON_MAP.put(FA_FILE_WORD_O, "\uf1c2");
        ICON_MAP.put(FA_FILE_ZIP_O, "\uf1c6");
        ICON_MAP.put(FA_FILES_O, "\uf0c5");
        ICON_MAP.put(FA_FILM, "\uf008");
        ICON_MAP.put(FA_FILTER, "\uf0b0");
        ICON_MAP.put(FA_FIRE, "\uf06d");
        ICON_MAP.put(FA_FIRE_EXTINGUISHER, "\uf134");
        ICON_MAP.put(FA_FIREFOX, "\uf269");
        ICON_MAP.put(FA_FLAG, "\uf024");
        ICON_MAP.put(FA_FLAG_CHECKERED, "\uf11e");
        ICON_MAP.put(FA_FLAG_O, "\uf11d");
        ICON_MAP.put(FA_FLASH, "\uf0e7");
        ICON_MAP.put(FA_FLASK, "\uf0c3");
        ICON_MAP.put(FA_FLICKR, "\uf16e");
        ICON_MAP.put(FA_FLOPPY_O, "\uf0c7");
        ICON_MAP.put(FA_FOLDER, "\uf07b");
        ICON_MAP.put(FA_FOLDER_O, "\uf114");
        ICON_MAP.put(FA_FOLDER_OPEN, "\uf07c");
        ICON_MAP.put(FA_FOLDER_OPEN_O, "\uf115");
        ICON_MAP.put(FA_FONT, "\uf031");
        ICON_MAP.put(FA_FONTICONS, "\uf280");
        ICON_MAP.put(FA_FORT_AWESOME, "\uf286");
        ICON_MAP.put(FA_FORUMBEE, "\uf211");
        ICON_MAP.put(FA_FORWARD, "\uf04e");
        ICON_MAP.put(FA_FOURSQUARE, "\uf180");
        ICON_MAP.put(FA_FROWN_O, "\uf119");
        ICON_MAP.put(FA_FUTBOL_O, "\uf1e3");
        ICON_MAP.put(FA_GAMEPAD, "\uf11b");
        ICON_MAP.put(FA_GAVEL, "\uf0e3");
        ICON_MAP.put(FA_GBP, "\uf154");
        ICON_MAP.put(FA_GE, "\uf1d1");
        ICON_MAP.put(FA_GEAR, "\uf013");
        ICON_MAP.put(FA_GEARS, "\uf085");
        ICON_MAP.put(FA_GENDERLESS, "\uf22d");
        ICON_MAP.put(FA_GET_POCKET, "\uf265");
        ICON_MAP.put(FA_GG, "\uf260");
        ICON_MAP.put(FA_GG_CIRCLE, "\uf261");
        ICON_MAP.put(FA_GIFT, "\uf06b");
        ICON_MAP.put(FA_GIT, "\uf1d3");
        ICON_MAP.put(FA_GIT_SQUARE, "\uf1d2");
        ICON_MAP.put(FA_GITHUB, "\uf09b");
        ICON_MAP.put(FA_GITHUB_ALT, "\uf113");
        ICON_MAP.put(FA_GITHUB_SQUARE, "\uf092");
        ICON_MAP.put(FA_GITTIP, "\uf184");
        ICON_MAP.put(FA_GLASS, "\uf000");
        ICON_MAP.put(FA_GLOBE, "\uf0ac");
        ICON_MAP.put(FA_GOOGLE, "\uf1a0");
        ICON_MAP.put(FA_GOOGLE_PLUS, "\uf0d5");
        ICON_MAP.put(FA_GOOGLE_PLUS_SQUARE, "\uf0d4");
        ICON_MAP.put(FA_GOOGLE_WALLET, "\uf1ee");
        ICON_MAP.put(FA_GRADUATION_CAP, "\uf19d");
        ICON_MAP.put(FA_GRATIPAY, "\uf184");
        ICON_MAP.put(FA_GROUP, "\uf0c0");
        ICON_MAP.put(FA_H_SQUARE, "\uf0fd");
        ICON_MAP.put(FA_HACKER_NEWS, "\uf1d4");
        ICON_MAP.put(FA_HAND_GRAB_O, "\uf255");
        ICON_MAP.put(FA_HAND_LIZARD_O, "\uf258");
        ICON_MAP.put(FA_HAND_O_DOWN, "\uf0a7");
        ICON_MAP.put(FA_HAND_O_LEFT, "\uf0a5");
        ICON_MAP.put(FA_HAND_O_RIGHT, "\uf0a4");
        ICON_MAP.put(FA_HAND_O_UP, "\uf0a6");
        ICON_MAP.put(FA_HAND_PAPER_O, "\uf256");
        ICON_MAP.put(FA_HAND_PEACE_O, "\uf25b");
        ICON_MAP.put(FA_HAND_POINTER_O, "\uf25a");
        ICON_MAP.put(FA_HAND_ROCK_O, "\uf255");
        ICON_MAP.put(FA_HAND_SCISSORS_O, "\uf257");
        ICON_MAP.put(FA_HAND_SPOCK_O, "\uf259");
        ICON_MAP.put(FA_HAND_STOP_O, "\uf256");
        ICON_MAP.put(FA_HASHTAG, "\uf292");
        ICON_MAP.put(FA_HDD_O, "\uf0a0");
        ICON_MAP.put(FA_HEADER, "\uf1dc");
        ICON_MAP.put(FA_HEADPHONES, "\uf025");
        ICON_MAP.put(FA_HEART, "\uf004");
        ICON_MAP.put(FA_HEART_O, "\uf08a");
        ICON_MAP.put(FA_HEARTBEAT, "\uf21e");
        ICON_MAP.put(FA_HISTORY, "\uf1da");
        ICON_MAP.put(FA_HOME, "\uf015");
        ICON_MAP.put(FA_HOSPITAL_O, "\uf0f8");
        ICON_MAP.put(FA_HOTEL, "\uf236");
        ICON_MAP.put(FA_HOURGLASS, "\uf254");
        ICON_MAP.put(FA_HOURGLASS_1, "\uf251");
        ICON_MAP.put(FA_HOURGLASS_2, "\uf252");
        ICON_MAP.put(FA_HOURGLASS_3, "\uf253");
        ICON_MAP.put(FA_HOURGLASS_END, "\uf253");
        ICON_MAP.put(FA_HOURGLASS_HALF, "\uf252");
        ICON_MAP.put(FA_HOURGLASS_O, "\uf250");
        ICON_MAP.put(FA_HOURGLASS_START, "\uf251");
        ICON_MAP.put(FA_HOUZZ, "\uf27c");
        ICON_MAP.put(FA_HTML5, "\uf13b");
        ICON_MAP.put(FA_I_CURSOR, "\uf246");
        ICON_MAP.put(FA_ILS, "\uf20b");
        ICON_MAP.put(FA_IMAGE, "\uf03e");
        ICON_MAP.put(FA_INBOX, "\uf01c");
        ICON_MAP.put(FA_INDENT, "\uf03c");
        ICON_MAP.put(FA_INDUSTRY, "\uf275");
        ICON_MAP.put(FA_INFO, "\uf129");
        ICON_MAP.put(FA_INFO_CIRCLE, "\uf05a");
        ICON_MAP.put(FA_INR, "\uf156");
        ICON_MAP.put(FA_INSTAGRAM, "\uf16d");
        ICON_MAP.put(FA_INSTITUTION, "\uf19c");
        ICON_MAP.put(FA_INTERNET_EXPLORER, "\uf26b");
        ICON_MAP.put(FA_INTERSEX, "\uf224");
        ICON_MAP.put(FA_IOXHOST, "\uf208");
        ICON_MAP.put(FA_ITALIC, "\uf033");
        ICON_MAP.put(FA_JOOMLA, "\uf1aa");
        ICON_MAP.put(FA_JPY, "\uf157");
        ICON_MAP.put(FA_JSFIDDLE, "\uf1cc");
        ICON_MAP.put(FA_KEY, "\uf084");
        ICON_MAP.put(FA_KEYBOARD_O, "\uf11c");
        ICON_MAP.put(FA_KRW, "\uf159");
        ICON_MAP.put(FA_LANGUAGE, "\uf1ab");
        ICON_MAP.put(FA_LAPTOP, "\uf109");
        ICON_MAP.put(FA_LASTFM, "\uf202");
        ICON_MAP.put(FA_LASTFM_SQUARE, "\uf203");
        ICON_MAP.put(FA_LEAF, "\uf06c");
        ICON_MAP.put(FA_LEANPUB, "\uf212");
        ICON_MAP.put(FA_LEGAL, "\uf0e3");
        ICON_MAP.put(FA_LEMON_O, "\uf094");
        ICON_MAP.put(FA_LEVEL_DOWN, "\uf149");
        ICON_MAP.put(FA_LEVEL_UP, "\uf148");
        ICON_MAP.put(FA_LIFE_BOUY, "\uf1cd");
        ICON_MAP.put(FA_LIFE_BUOY, "\uf1cd");
        ICON_MAP.put(FA_LIFE_RING, "\uf1cd");
        ICON_MAP.put(FA_LIFE_SAVER, "\uf1cd");
        ICON_MAP.put(FA_LIGHTBULB_O, "\uf0eb");
        ICON_MAP.put(FA_LINE_CHART, "\uf201");
        ICON_MAP.put(FA_LINK, "\uf0c1");
        ICON_MAP.put(FA_LINKEDIN, "\uf0e1");
        ICON_MAP.put(FA_LINKEDIN_SQUARE, "\uf08c");
        ICON_MAP.put(FA_LINUX, "\uf17c");
        ICON_MAP.put(FA_LIST, "\uf03a");
        ICON_MAP.put(FA_LIST_ALT, "\uf022");
        ICON_MAP.put(FA_LIST_OL, "\uf0cb");
        ICON_MAP.put(FA_LIST_UL, "\uf0ca");
        ICON_MAP.put(FA_LOCATION_ARROW, "\uf124");
        ICON_MAP.put(FA_LOCK, "\uf023");
        ICON_MAP.put(FA_LONG_ARROW_DOWN, "\uf175");
        ICON_MAP.put(FA_LONG_ARROW_LEFT, "\uf177");
        ICON_MAP.put(FA_LONG_ARROW_RIGHT, "\uf178");
        ICON_MAP.put(FA_LONG_ARROW_UP, "\uf176");
        ICON_MAP.put(FA_MAGIC, "\uf0d0");
        ICON_MAP.put(FA_MAGNET, "\uf076");
        ICON_MAP.put(FA_MAIL_FORWARD, "\uf064");
        ICON_MAP.put(FA_MAIL_REPLY, "\uf112");
        ICON_MAP.put(FA_MAIL_REPLY_ALL, "\uf122");
        ICON_MAP.put(FA_MALE, "\uf183");
        ICON_MAP.put(FA_MAP, "\uf279");
        ICON_MAP.put(FA_MAP_MARKER, "\uf041");
        ICON_MAP.put(FA_MAP_O, "\uf278");
        ICON_MAP.put(FA_MAP_PIN, "\uf276");
        ICON_MAP.put(FA_MAP_SIGNS, "\uf277");
        ICON_MAP.put(FA_MARS, "\uf222");
        ICON_MAP.put(FA_MARS_DOUBLE, "\uf227");
        ICON_MAP.put(FA_MARS_STROKE, "\uf229");
        ICON_MAP.put(FA_MARS_STROKE_H, "\uf22b");
        ICON_MAP.put(FA_MARS_STROKE_V, "\uf22a");
        ICON_MAP.put(FA_MAXCDN, "\uf136");
        ICON_MAP.put(FA_MEANPATH, "\uf20c");
        ICON_MAP.put(FA_MEDIUM, "\uf23a");
        ICON_MAP.put(FA_MEDKIT, "\uf0fa");
        ICON_MAP.put(FA_MEH_O, "\uf11a");
        ICON_MAP.put(FA_MERCURY, "\uf223");
        ICON_MAP.put(FA_MICROPHONE, "\uf130");
        ICON_MAP.put(FA_MICROPHONE_SLASH, "\uf131");
        ICON_MAP.put(FA_MINUS, "\uf068");
        ICON_MAP.put(FA_MINUS_CIRCLE, "\uf056");
        ICON_MAP.put(FA_MINUS_SQUARE, "\uf146");
        ICON_MAP.put(FA_MINUS_SQUARE_O, "\uf147");
        ICON_MAP.put(FA_MIXCLOUD, "\uf289");
        ICON_MAP.put(FA_MOBILE, "\uf10b");
        ICON_MAP.put(FA_MOBILE_PHONE, "\uf10b");
        ICON_MAP.put(FA_MODX, "\uf285");
        ICON_MAP.put(FA_MONEY, "\uf0d6");
        ICON_MAP.put(FA_MOON_O, "\uf186");
        ICON_MAP.put(FA_MORTAR_BOARD, "\uf19d");
        ICON_MAP.put(FA_MOTORCYCLE, "\uf21c");
        ICON_MAP.put(FA_MOUSE_POINTER, "\uf245");
        ICON_MAP.put(FA_MUSIC, "\uf001");
        ICON_MAP.put(FA_NAVICON, "\uf0c9");
        ICON_MAP.put(FA_NEUTER, "\uf22c");
        ICON_MAP.put(FA_NEWSPAPER_O, "\uf1ea");
        ICON_MAP.put(FA_OBJECT_GROUP, "\uf247");
        ICON_MAP.put(FA_OBJECT_UNGROUP, "\uf248");
        ICON_MAP.put(FA_ODNOKLASSNIKI, "\uf263");
        ICON_MAP.put(FA_ODNOKLASSNIKI_SQUARE, "\uf264");
        ICON_MAP.put(FA_OPENCART, "\uf23d");
        ICON_MAP.put(FA_OPENID, "\uf19b");
        ICON_MAP.put(FA_OPERA, "\uf26a");
        ICON_MAP.put(FA_OPTIN_MONSTER, "\uf23c");
        ICON_MAP.put(FA_OUTDENT, "\uf03b");
        ICON_MAP.put(FA_PAGELINES, "\uf18c");
        ICON_MAP.put(FA_PAINT_BRUSH, "\uf1fc");
        ICON_MAP.put(FA_PAPER_PLANE, "\uf1d8");
        ICON_MAP.put(FA_PAPER_PLANE_O, "\uf1d9");
        ICON_MAP.put(FA_PAPERCLIP, "\uf0c6");
        ICON_MAP.put(FA_PARAGRAPH, "\uf1dd");
        ICON_MAP.put(FA_PASTE, "\uf0ea");
        ICON_MAP.put(FA_PAUSE, "\uf04c");
        ICON_MAP.put(FA_PAUSE_CIRCLE, "\uf28b");
        ICON_MAP.put(FA_PAUSE_CIRCLE_O, "\uf28c");
        ICON_MAP.put(FA_PAW, "\uf1b0");
        ICON_MAP.put(FA_PAYPAL, "\uf1ed");
        ICON_MAP.put(FA_PENCIL, "\uf040");
        ICON_MAP.put(FA_PENCIL_SQUARE, "\uf14b");
        ICON_MAP.put(FA_PENCIL_SQUARE_O, "\uf044");
        ICON_MAP.put(FA_PERCENT, "\uf295");
        ICON_MAP.put(FA_PHONE, "\uf095");
        ICON_MAP.put(FA_PHONE_SQUARE, "\uf098");
        ICON_MAP.put(FA_PHOTO, "\uf03e");
        ICON_MAP.put(FA_PICTURE_O, "\uf03e");
        ICON_MAP.put(FA_PIE_CHART, "\uf200");
        ICON_MAP.put(FA_PIED_PIPER, "\uf1a7");
        ICON_MAP.put(FA_PIED_PIPER_ALT, "\uf1a8");
        ICON_MAP.put(FA_PINTEREST, "\uf0d2");
        ICON_MAP.put(FA_PINTEREST_P, "\uf231");
        ICON_MAP.put(FA_PINTEREST_SQUARE, "\uf0d3");
        ICON_MAP.put(FA_PLANE, "\uf072");
        ICON_MAP.put(FA_PLAY, "\uf04b");
        ICON_MAP.put(FA_PLAY_CIRCLE, "\uf144");
        ICON_MAP.put(FA_PLAY_CIRCLE_O, "\uf01d");
        ICON_MAP.put(FA_PLUG, "\uf1e6");
        ICON_MAP.put(FA_PLUS, "\uf067");
        ICON_MAP.put(FA_PLUS_CIRCLE, "\uf055");
        ICON_MAP.put(FA_PLUS_SQUARE, "\uf0fe");
        ICON_MAP.put(FA_PLUS_SQUARE_O, "\uf196");
        ICON_MAP.put(FA_POWER_OFF, "\uf011");
        ICON_MAP.put(FA_PRINT, "\uf02f");
        ICON_MAP.put(FA_PRODUCT_HUNT, "\uf288");
        ICON_MAP.put(FA_PUZZLE_PIECE, "\uf12e");
        ICON_MAP.put(FA_QQ, "\uf1d6");
        ICON_MAP.put(FA_QRCODE, "\uf029");
        ICON_MAP.put(FA_QUESTION, "\uf128");
        ICON_MAP.put(FA_QUESTION_CIRCLE, "\uf059");
        ICON_MAP.put(FA_QUOTE_LEFT, "\uf10d");
        ICON_MAP.put(FA_QUOTE_RIGHT, "\uf10e");
        ICON_MAP.put(FA_RA, "\uf1d0");
        ICON_MAP.put(FA_RANDOM, "\uf074");
        ICON_MAP.put(FA_REBEL, "\uf1d0");
        ICON_MAP.put(FA_RECYCLE, "\uf1b8");
        ICON_MAP.put(FA_REDDIT, "\uf1a1");
        ICON_MAP.put(FA_REDDIT_ALIEN, "\uf281");
        ICON_MAP.put(FA_REDDIT_SQUARE, "\uf1a2");
        ICON_MAP.put(FA_REFRESH, "\uf021");
        ICON_MAP.put(FA_REGISTERED, "\uf25d");
        ICON_MAP.put(FA_REMOVE, "\uf00d");
        ICON_MAP.put(FA_RENREN, "\uf18b");
        ICON_MAP.put(FA_REORDER, "\uf0c9");
        ICON_MAP.put(FA_REPEAT, "\uf01e");
        ICON_MAP.put(FA_REPLY, "\uf112");
        ICON_MAP.put(FA_REPLY_ALL, "\uf122");
        ICON_MAP.put(FA_RETWEET, "\uf079");
        ICON_MAP.put(FA_RMB, "\uf157");
        ICON_MAP.put(FA_ROAD, "\uf018");
        ICON_MAP.put(FA_ROCKET, "\uf135");
        ICON_MAP.put(FA_ROTATE_LEFT, "\uf0e2");
        ICON_MAP.put(FA_ROTATE_RIGHT, "\uf01e");
        ICON_MAP.put(FA_ROUBLE, "\uf158");
        ICON_MAP.put(FA_RSS, "\uf09e");
        ICON_MAP.put(FA_RSS_SQUARE, "\uf143");
        ICON_MAP.put(FA_RUB, "\uf158");
        ICON_MAP.put(FA_RUBLE, "\uf158");
        ICON_MAP.put(FA_RUPEE, "\uf156");
        ICON_MAP.put(FA_SAFARI, "\uf267");
        ICON_MAP.put(FA_SAVE, "\uf0c7");
        ICON_MAP.put(FA_SCISSORS, "\uf0c4");
        ICON_MAP.put(FA_SCRIBD, "\uf28a");
        ICON_MAP.put(FA_SEARCH, "\uf002");
        ICON_MAP.put(FA_SEARCH_MINUS, "\uf010");
        ICON_MAP.put(FA_SEARCH_PLUS, "\uf00e");
        ICON_MAP.put(FA_SELLSY, "\uf213");
        ICON_MAP.put(FA_SEND, "\uf1d8");
        ICON_MAP.put(FA_SEND_O, "\uf1d9");
        ICON_MAP.put(FA_SERVER, "\uf233");
        ICON_MAP.put(FA_SHARE, "\uf064");
        ICON_MAP.put(FA_SHARE_ALT, "\uf1e0");
        ICON_MAP.put(FA_SHARE_ALT_SQUARE, "\uf1e1");
        ICON_MAP.put(FA_SHARE_SQUARE, "\uf14d");
        ICON_MAP.put(FA_SHARE_SQUARE_O, "\uf045");
        ICON_MAP.put(FA_SHEKEL, "\uf20b");
        ICON_MAP.put(FA_SHEQEL, "\uf20b");
        ICON_MAP.put(FA_SHIELD, "\uf132");
        ICON_MAP.put(FA_SHIP, "\uf21a");
        ICON_MAP.put(FA_SHIRTSINBULK, "\uf214");
        ICON_MAP.put(FA_SHOPPING_BAG, "\uf290");
        ICON_MAP.put(FA_SHOPPING_BASKET, "\uf291");
        ICON_MAP.put(FA_SHOPPING_CART, "\uf07a");
        ICON_MAP.put(FA_SIGN_IN, "\uf090");
        ICON_MAP.put(FA_SIGN_OUT, "\uf08b");
        ICON_MAP.put(FA_SIGNAL, "\uf012");
        ICON_MAP.put(FA_SIMPLYBUILT, "\uf215");
        ICON_MAP.put(FA_SITEMAP, "\uf0e8");
        ICON_MAP.put(FA_SKYATLAS, "\uf216");
        ICON_MAP.put(FA_SKYPE, "\uf17e");
        ICON_MAP.put(FA_SLACK, "\uf198");
        ICON_MAP.put(FA_SLIDERS, "\uf1de");
        ICON_MAP.put(FA_SLIDESHARE, "\uf1e7");
        ICON_MAP.put(FA_SMILE_O, "\uf118");
        ICON_MAP.put(FA_SOCCER_BALL_O, "\uf1e3");
        ICON_MAP.put(FA_SORT, "\uf0dc");
        ICON_MAP.put(FA_SORT_ALPHA_ASC, "\uf15d");
        ICON_MAP.put(FA_SORT_ALPHA_DESC, "\uf15e");
        ICON_MAP.put(FA_SORT_AMOUNT_ASC, "\uf160");
        ICON_MAP.put(FA_SORT_AMOUNT_DESC, "\uf161");
        ICON_MAP.put(FA_SORT_ASC, "\uf0de");
        ICON_MAP.put(FA_SORT_DESC, "\uf0dd");
        ICON_MAP.put(FA_SORT_DOWN, "\uf0dd");
        ICON_MAP.put(FA_SORT_NUMERIC_ASC, "\uf162");
        ICON_MAP.put(FA_SORT_NUMERIC_DESC, "\uf163");
        ICON_MAP.put(FA_SORT_UP, "\uf0de");
        ICON_MAP.put(FA_SOUNDCLOUD, "\uf1be");
        ICON_MAP.put(FA_SPACE_SHUTTLE, "\uf197");
        ICON_MAP.put(FA_SPINNER, "\uf110");
        ICON_MAP.put(FA_SPOON, "\uf1b1");
        ICON_MAP.put(FA_SPOTIFY, "\uf1bc");
        ICON_MAP.put(FA_SQUARE, "\uf0c8");
        ICON_MAP.put(FA_SQUARE_O, "\uf096");
        ICON_MAP.put(FA_STACK_EXCHANGE, "\uf18d");
        ICON_MAP.put(FA_STACK_OVERFLOW, "\uf16c");
        ICON_MAP.put(FA_STAR, "\uf005");
        ICON_MAP.put(FA_STAR_HALF, "\uf089");
        ICON_MAP.put(FA_STAR_HALF_EMPTY, "\uf123");
        ICON_MAP.put(FA_STAR_HALF_FULL, "\uf123");
        ICON_MAP.put(FA_STAR_HALF_O, "\uf123");
        ICON_MAP.put(FA_STAR_O, "\uf006");
        ICON_MAP.put(FA_STEAM, "\uf1b6");
        ICON_MAP.put(FA_STEAM_SQUARE, "\uf1b7");
        ICON_MAP.put(FA_STEP_BACKWARD, "\uf048");
        ICON_MAP.put(FA_STEP_FORWARD, "\uf051");
        ICON_MAP.put(FA_STETHOSCOPE, "\uf0f1");
        ICON_MAP.put(FA_STICKY_NOTE, "\uf249");
        ICON_MAP.put(FA_STICKY_NOTE_O, "\uf24a");
        ICON_MAP.put(FA_STOP, "\uf04d");
        ICON_MAP.put(FA_STOP_CIRCLE, "\uf28d");
        ICON_MAP.put(FA_STOP_CIRCLE_O, "\uf28e");
        ICON_MAP.put(FA_STREET_VIEW, "\uf21d");
        ICON_MAP.put(FA_STRIKETHROUGH, "\uf0cc");
        ICON_MAP.put(FA_STUMBLEUPON, "\uf1a4");
        ICON_MAP.put(FA_STUMBLEUPON_CIRCLE, "\uf1a3");
        ICON_MAP.put(FA_SUBSCRIPT, "\uf12c");
        ICON_MAP.put(FA_SUBWAY, "\uf239");
        ICON_MAP.put(FA_SUITCASE, "\uf0f2");
        ICON_MAP.put(FA_SUN_O, "\uf185");
        ICON_MAP.put(FA_SUPERSCRIPT, "\uf12b");
        ICON_MAP.put(FA_SUPPORT, "\uf1cd");
        ICON_MAP.put(FA_TABLE, "\uf0ce");
        ICON_MAP.put(FA_TABLET, "\uf10a");
        ICON_MAP.put(FA_TACHOMETER, "\uf0e4");
        ICON_MAP.put(FA_TAG, "\uf02b");
        ICON_MAP.put(FA_TAGS, "\uf02c");
        ICON_MAP.put(FA_TASKS, "\uf0ae");
        ICON_MAP.put(FA_TAXI, "\uf1ba");
        ICON_MAP.put(FA_TELEVISION, "\uf26c");
        ICON_MAP.put(FA_TENCENT_WEIBO, "\uf1d5");
        ICON_MAP.put(FA_TERMINAL, "\uf120");
        ICON_MAP.put(FA_TEXT_HEIGHT, "\uf034");
        ICON_MAP.put(FA_TEXT_WIDTH, "\uf035");
        ICON_MAP.put(FA_TH, "\uf00a");
        ICON_MAP.put(FA_TH_LARGE, "\uf009");
        ICON_MAP.put(FA_TH_LIST, "\uf00b");
        ICON_MAP.put(FA_THUMB_TACK, "\uf08d");
        ICON_MAP.put(FA_THUMBS_DOWN, "\uf165");
        ICON_MAP.put(FA_THUMBS_O_DOWN, "\uf088");
        ICON_MAP.put(FA_THUMBS_O_UP, "\uf087");
        ICON_MAP.put(FA_THUMBS_UP, "\uf164");
        ICON_MAP.put(FA_TICKET, "\uf145");
        ICON_MAP.put(FA_TIMES, "\uf00d");
        ICON_MAP.put(FA_TIMES_CIRCLE, "\uf057");
        ICON_MAP.put(FA_TIMES_CIRCLE_O, "\uf05c");
        ICON_MAP.put(FA_TINT, "\uf043");
        ICON_MAP.put(FA_TOGGLE_DOWN, "\uf150");
        ICON_MAP.put(FA_TOGGLE_LEFT, "\uf191");
        ICON_MAP.put(FA_TOGGLE_OFF, "\uf204");
        ICON_MAP.put(FA_TOGGLE_ON, "\uf205");
        ICON_MAP.put(FA_TOGGLE_RIGHT, "\uf152");
        ICON_MAP.put(FA_TOGGLE_UP, "\uf151");
        ICON_MAP.put(FA_TRADEMARK, "\uf25c");
        ICON_MAP.put(FA_TRAIN, "\uf238");
        ICON_MAP.put(FA_TRANSGENDER, "\uf224");
        ICON_MAP.put(FA_TRANSGENDER_ALT, "\uf225");
        ICON_MAP.put(FA_TRASH, "\uf1f8");
        ICON_MAP.put(FA_TRASH_O, "\uf014");
        ICON_MAP.put(FA_TREE, "\uf1bb");
        ICON_MAP.put(FA_TRELLO, "\uf181");
        ICON_MAP.put(FA_TRIPADVISOR, "\uf262");
        ICON_MAP.put(FA_TROPHY, "\uf091");
        ICON_MAP.put(FA_TRUCK, "\uf0d1");
        ICON_MAP.put(FA_TRY, "\uf195");
        ICON_MAP.put(FA_TTY, "\uf1e4");
        ICON_MAP.put(FA_TUMBLR, "\uf173");
        ICON_MAP.put(FA_TUMBLR_SQUARE, "\uf174");
        ICON_MAP.put(FA_TURKISH_LIRA, "\uf195");
        ICON_MAP.put(FA_TV, "\uf26c");
        ICON_MAP.put(FA_TWITCH, "\uf1e8");
        ICON_MAP.put(FA_TWITTER, "\uf099");
        ICON_MAP.put(FA_TWITTER_SQUARE, "\uf081");
        ICON_MAP.put(FA_UMBRELLA, "\uf0e9");
        ICON_MAP.put(FA_UNDERLINE, "\uf0cd");
        ICON_MAP.put(FA_UNDO, "\uf0e2");
        ICON_MAP.put(FA_UNIVERSITY, "\uf19c");
        ICON_MAP.put(FA_UNLINK, "\uf127");
        ICON_MAP.put(FA_UNLOCK, "\uf09c");
        ICON_MAP.put(FA_UNLOCK_ALT, "\uf13e");
        ICON_MAP.put(FA_UNSORTED, "\uf0dc");
        ICON_MAP.put(FA_UPLOAD, "\uf093");
        ICON_MAP.put(FA_USB, "\uf287");
        ICON_MAP.put(FA_USD, "\uf155");
        ICON_MAP.put(FA_USER, "\uf007");
        ICON_MAP.put(FA_USER_MD, "\uf0f0");
        ICON_MAP.put(FA_USER_PLUS, "\uf234");
        ICON_MAP.put(FA_USER_SECRET, "\uf21b");
        ICON_MAP.put(FA_USER_TIMES, "\uf235");
        ICON_MAP.put(FA_USERS, "\uf0c0");
        ICON_MAP.put(FA_VENUS, "\uf221");
        ICON_MAP.put(FA_VENUS_DOUBLE, "\uf226");
        ICON_MAP.put(FA_VENUS_MARS, "\uf228");
        ICON_MAP.put(FA_VIACOIN, "\uf237");
        ICON_MAP.put(FA_VIDEO_CAMERA, "\uf03d");
        ICON_MAP.put(FA_VIMEO, "\uf27d");
        ICON_MAP.put(FA_VIMEO_SQUARE, "\uf194");
        ICON_MAP.put(FA_VINE, "\uf1ca");
        ICON_MAP.put(FA_VK, "\uf189");
        ICON_MAP.put(FA_VOLUME_DOWN, "\uf027");
        ICON_MAP.put(FA_VOLUME_OFF, "\uf026");
        ICON_MAP.put(FA_VOLUME_UP, "\uf028");
        ICON_MAP.put(FA_WARNING, "\uf071");
        ICON_MAP.put(FA_WECHAT, "\uf1d7");
        ICON_MAP.put(FA_WEIBO, "\uf18a");
        ICON_MAP.put(FA_WEIXIN, "\uf1d7");
        ICON_MAP.put(FA_WHATSAPP, "\uf232");
        ICON_MAP.put(FA_WHEELCHAIR, "\uf193");
        ICON_MAP.put(FA_WIFI, "\uf1eb");
        ICON_MAP.put(FA_WIKIPEDIA_W, "\uf266");
        ICON_MAP.put(FA_WINDOWS, "\uf17a");
        ICON_MAP.put(FA_WON, "\uf159");
        ICON_MAP.put(FA_WORDPRESS, "\uf19a");
        ICON_MAP.put(FA_WRENCH, "\uf0ad");
        ICON_MAP.put(FA_XING, "\uf168");
        ICON_MAP.put(FA_XING_SQUARE, "\uf169");
        ICON_MAP.put(FA_Y_COMBINATOR, "\uf23b");
        ICON_MAP.put(FA_Y_COMBINATOR_SQUARE, "\uf1d4");
        ICON_MAP.put(FA_YAHOO, "\uf19e");
        ICON_MAP.put(FA_YC, "\uf23b");
        ICON_MAP.put(FA_YC_SQUARE, "\uf1d4");
        ICON_MAP.put(FA_YELP, "\uf1e9");
        ICON_MAP.put(FA_YEN, "\uf157");
        ICON_MAP.put(FA_YOUTUBE, "\uf167");
        ICON_MAP.put(FA_YOUTUBE_PLAY, "\uf16a");
        ICON_MAP.put(FA_YOUTUBE_SQUARE, "\uf166");


        ATTR_MAP.put(0, FA_ADJUST);
        ATTR_MAP.put(1, FA_ADN);
        ATTR_MAP.put(2, FA_ALIGN_CENTER);
        ATTR_MAP.put(3, FA_ALIGN_JUSTIFY);
        ATTR_MAP.put(4, FA_ALIGN_LEFT);
        ATTR_MAP.put(5, FA_ALIGN_RIGHT);
        ATTR_MAP.put(6, FA_AMAZON);
        ATTR_MAP.put(7, FA_AMBULANCE);
        ATTR_MAP.put(8, FA_ANCHOR);
        ATTR_MAP.put(9, FA_ANDROID);
        ATTR_MAP.put(10, FA_ANGELLIST);
        ATTR_MAP.put(11, FA_ANGLE_DOUBLE_DOWN);
        ATTR_MAP.put(12, FA_ANGLE_DOUBLE_LEFT);
        ATTR_MAP.put(13, FA_ANGLE_DOUBLE_RIGHT);
        ATTR_MAP.put(14, FA_ANGLE_DOUBLE_UP);
        ATTR_MAP.put(15, FA_ANGLE_DOWN);
        ATTR_MAP.put(16, FA_ANGLE_LEFT);
        ATTR_MAP.put(17, FA_ANGLE_RIGHT);
        ATTR_MAP.put(18, FA_ANGLE_UP);
        ATTR_MAP.put(19, FA_APPLE);
        ATTR_MAP.put(20, FA_ARCHIVE);
        ATTR_MAP.put(21, FA_AREA_CHART);
        ATTR_MAP.put(22, FA_ARROW_CIRCLE_DOWN);
        ATTR_MAP.put(23, FA_ARROW_CIRCLE_LEFT);
        ATTR_MAP.put(24, FA_ARROW_CIRCLE_O_DOWN);
        ATTR_MAP.put(25, FA_ARROW_CIRCLE_O_LEFT);
        ATTR_MAP.put(26, FA_ARROW_CIRCLE_O_RIGHT);
        ATTR_MAP.put(27, FA_ARROW_CIRCLE_O_UP);
        ATTR_MAP.put(28, FA_ARROW_CIRCLE_RIGHT);
        ATTR_MAP.put(29, FA_ARROW_CIRCLE_UP);
        ATTR_MAP.put(30, FA_ARROW_DOWN);
        ATTR_MAP.put(31, FA_ARROW_LEFT);
        ATTR_MAP.put(32, FA_ARROW_RIGHT);
        ATTR_MAP.put(33, FA_ARROW_UP);
        ATTR_MAP.put(34, FA_ARROWS);
        ATTR_MAP.put(35, FA_ARROWS_ALT);
        ATTR_MAP.put(36, FA_ARROWS_H);
        ATTR_MAP.put(37, FA_ARROWS_V);
        ATTR_MAP.put(38, FA_ASTERISK);
        ATTR_MAP.put(39, FA_AT);
        ATTR_MAP.put(40, FA_AUTOMOBILE);
        ATTR_MAP.put(41, FA_BACKWARD);
        ATTR_MAP.put(42, FA_BALANCE_SCALE);
        ATTR_MAP.put(43, FA_BAN);
        ATTR_MAP.put(44, FA_BANK);
        ATTR_MAP.put(45, FA_BAR_CHART);
        ATTR_MAP.put(46, FA_BAR_CHART_O);
        ATTR_MAP.put(47, FA_BARCODE);
        ATTR_MAP.put(48, FA_BARS);
        ATTR_MAP.put(49, FA_BATTERY_0);
        ATTR_MAP.put(50, FA_BATTERY_1);
        ATTR_MAP.put(51, FA_BATTERY_2);
        ATTR_MAP.put(52, FA_BATTERY_3);
        ATTR_MAP.put(53, FA_BATTERY_4);
        ATTR_MAP.put(54, FA_BATTERY_EMPTY);
        ATTR_MAP.put(55, FA_BATTERY_FULL);
        ATTR_MAP.put(56, FA_BATTERY_HALF);
        ATTR_MAP.put(57, FA_BATTERY_QUARTER);
        ATTR_MAP.put(58, FA_BATTERY_THREE_QUARTERS);
        ATTR_MAP.put(59, FA_BED);
        ATTR_MAP.put(60, FA_BEER);
        ATTR_MAP.put(61, FA_BEHANCE);
        ATTR_MAP.put(62, FA_BEHANCE_SQUARE);
        ATTR_MAP.put(63, FA_BELL);
        ATTR_MAP.put(64, FA_BELL_O);
        ATTR_MAP.put(65, FA_BELL_SLASH);
        ATTR_MAP.put(66, FA_BELL_SLASH_O);
        ATTR_MAP.put(67, FA_BICYCLE);
        ATTR_MAP.put(68, FA_BINOCULARS);
        ATTR_MAP.put(69, FA_BIRTHDAY_CAKE);
        ATTR_MAP.put(70, FA_BITBUCKET);
        ATTR_MAP.put(71, FA_BITBUCKET_SQUARE);
        ATTR_MAP.put(72, FA_BITCOIN);
        ATTR_MAP.put(73, FA_BLACK_TIE);
        ATTR_MAP.put(74, FA_BLUETOOTH);
        ATTR_MAP.put(75, FA_BLUETOOTH_B);
        ATTR_MAP.put(76, FA_BOLD);
        ATTR_MAP.put(77, FA_BOLT);
        ATTR_MAP.put(78, FA_BOMB);
        ATTR_MAP.put(79, FA_BOOK);
        ATTR_MAP.put(80, FA_BOOKMARK);
        ATTR_MAP.put(81, FA_BOOKMARK_O);
        ATTR_MAP.put(82, FA_BRIEFCASE);
        ATTR_MAP.put(83, FA_BTC);
        ATTR_MAP.put(84, FA_BUG);
        ATTR_MAP.put(85, FA_BUILDING);
        ATTR_MAP.put(86, FA_BUILDING_O);
        ATTR_MAP.put(87, FA_BULLHORN);
        ATTR_MAP.put(88, FA_BULLSEYE);
        ATTR_MAP.put(89, FA_BUS);
        ATTR_MAP.put(90, FA_BUYSELLADS);
        ATTR_MAP.put(91, FA_CAB);
        ATTR_MAP.put(92, FA_CALCULATOR);
        ATTR_MAP.put(93, FA_CALENDAR);
        ATTR_MAP.put(94, FA_CALENDAR_CHECK_O);
        ATTR_MAP.put(95, FA_CALENDAR_MINUS_O);
        ATTR_MAP.put(96, FA_CALENDAR_O);
        ATTR_MAP.put(97, FA_CALENDAR_PLUS_O);
        ATTR_MAP.put(98, FA_CALENDAR_TIMES_O);
        ATTR_MAP.put(99, FA_CAMERA);
        ATTR_MAP.put(100, FA_CAMERA_RETRO);
        ATTR_MAP.put(101, FA_CAR);
        ATTR_MAP.put(102, FA_CARET_DOWN);
        ATTR_MAP.put(103, FA_CARET_LEFT);
        ATTR_MAP.put(104, FA_CARET_RIGHT);
        ATTR_MAP.put(105, FA_CARET_SQUARE_O_DOWN);
        ATTR_MAP.put(106, FA_CARET_SQUARE_O_LEFT);
        ATTR_MAP.put(107, FA_CARET_SQUARE_O_RIGHT);
        ATTR_MAP.put(108, FA_CARET_SQUARE_O_UP);
        ATTR_MAP.put(109, FA_CARET_UP);
        ATTR_MAP.put(110, FA_CART_ARROW_DOWN);
        ATTR_MAP.put(111, FA_CART_PLUS);
        ATTR_MAP.put(112, FA_CC);
        ATTR_MAP.put(113, FA_CC_AMEX);
        ATTR_MAP.put(114, FA_CC_DINERS_CLUB);
        ATTR_MAP.put(115, FA_CC_DISCOVER);
        ATTR_MAP.put(116, FA_CC_JCB);
        ATTR_MAP.put(117, FA_CC_MASTERCARD);
        ATTR_MAP.put(118, FA_CC_PAYPAL);
        ATTR_MAP.put(119, FA_CC_STRIPE);
        ATTR_MAP.put(120, FA_CC_VISA);
        ATTR_MAP.put(121, FA_CERTIFICATE);
        ATTR_MAP.put(122, FA_CHAIN);
        ATTR_MAP.put(123, FA_CHAIN_BROKEN);
        ATTR_MAP.put(124, FA_CHECK);
        ATTR_MAP.put(125, FA_CHECK_CIRCLE);
        ATTR_MAP.put(126, FA_CHECK_CIRCLE_O);
        ATTR_MAP.put(127, FA_CHECK_SQUARE);
        ATTR_MAP.put(128, FA_CHECK_SQUARE_O);
        ATTR_MAP.put(129, FA_CHEVRON_CIRCLE_DOWN);
        ATTR_MAP.put(130, FA_CHEVRON_CIRCLE_LEFT);
        ATTR_MAP.put(131, FA_CHEVRON_CIRCLE_RIGHT);
        ATTR_MAP.put(132, FA_CHEVRON_CIRCLE_UP);
        ATTR_MAP.put(133, FA_CHEVRON_DOWN);
        ATTR_MAP.put(134, FA_CHEVRON_LEFT);
        ATTR_MAP.put(135, FA_CHEVRON_RIGHT);
        ATTR_MAP.put(136, FA_CHEVRON_UP);
        ATTR_MAP.put(137, FA_CHILD);
        ATTR_MAP.put(138, FA_CHROME);
        ATTR_MAP.put(139, FA_CIRCLE);
        ATTR_MAP.put(140, FA_CIRCLE_O);
        ATTR_MAP.put(141, FA_CIRCLE_O_NOTCH);
        ATTR_MAP.put(142, FA_CIRCLE_THIN);
        ATTR_MAP.put(143, FA_CLIPBOARD);
        ATTR_MAP.put(144, FA_CLOCK_O);
        ATTR_MAP.put(145, FA_CLONE);
        ATTR_MAP.put(146, FA_CLOSE);
        ATTR_MAP.put(147, FA_CLOUD);
        ATTR_MAP.put(148, FA_CLOUD_DOWNLOAD);
        ATTR_MAP.put(149, FA_CLOUD_UPLOAD);
        ATTR_MAP.put(150, FA_CNY);
        ATTR_MAP.put(151, FA_CODE);
        ATTR_MAP.put(152, FA_CODE_FORK);
        ATTR_MAP.put(153, FA_CODEPEN);
        ATTR_MAP.put(154, FA_CODIEPIE);
        ATTR_MAP.put(155, FA_COFFEE);
        ATTR_MAP.put(156, FA_COG);
        ATTR_MAP.put(157, FA_COGS);
        ATTR_MAP.put(158, FA_COLUMNS);
        ATTR_MAP.put(159, FA_COMMENT);
        ATTR_MAP.put(160, FA_COMMENT_O);
        ATTR_MAP.put(161, FA_COMMENTING);
        ATTR_MAP.put(162, FA_COMMENTING_O);
        ATTR_MAP.put(163, FA_COMMENTS);
        ATTR_MAP.put(164, FA_COMMENTS_O);
        ATTR_MAP.put(165, FA_COMPASS);
        ATTR_MAP.put(166, FA_COMPRESS);
        ATTR_MAP.put(167, FA_CONNECTDEVELOP);
        ATTR_MAP.put(168, FA_CONTAO);
        ATTR_MAP.put(169, FA_COPY);
        ATTR_MAP.put(170, FA_COPYRIGHT);
        ATTR_MAP.put(171, FA_CREATIVE_COMMONS);
        ATTR_MAP.put(172, FA_CREDIT_CARD);
        ATTR_MAP.put(173, FA_CREDIT_CARD_ALT);
        ATTR_MAP.put(174, FA_CROP);
        ATTR_MAP.put(175, FA_CROSSHAIRS);
        ATTR_MAP.put(176, FA_CSS3);
        ATTR_MAP.put(177, FA_CUBE);
        ATTR_MAP.put(178, FA_CUBES);
        ATTR_MAP.put(179, FA_CUT);
        ATTR_MAP.put(180, FA_CUTLERY);
        ATTR_MAP.put(181, FA_DASHBOARD);
        ATTR_MAP.put(182, FA_DASHCUBE);
        ATTR_MAP.put(183, FA_DATABASE);
        ATTR_MAP.put(184, FA_DEDENT);
        ATTR_MAP.put(185, FA_DELICIOUS);
        ATTR_MAP.put(186, FA_DESKTOP);
        ATTR_MAP.put(187, FA_DEVIANTART);
        ATTR_MAP.put(188, FA_DIAMOND);
        ATTR_MAP.put(189, FA_DIGG);
        ATTR_MAP.put(190, FA_DOLLAR);
        ATTR_MAP.put(191, FA_DOT_CIRCLE_O);
        ATTR_MAP.put(192, FA_DOWNLOAD);
        ATTR_MAP.put(193, FA_DRIBBBLE);
        ATTR_MAP.put(194, FA_DROPBOX);
        ATTR_MAP.put(195, FA_DRUPAL);
        ATTR_MAP.put(196, FA_EDGE);
        ATTR_MAP.put(197, FA_EDIT);
        ATTR_MAP.put(198, FA_EJECT);
        ATTR_MAP.put(199, FA_ELLIPSIS_H);
        ATTR_MAP.put(200, FA_ELLIPSIS_V);
        ATTR_MAP.put(201, FA_EMPIRE);
        ATTR_MAP.put(202, FA_ENVELOPE);
        ATTR_MAP.put(203, FA_ENVELOPE_O);
        ATTR_MAP.put(204, FA_ENVELOPE_SQUARE);
        ATTR_MAP.put(205, FA_ERASER);
        ATTR_MAP.put(206, FA_EUR);
        ATTR_MAP.put(207, FA_EURO);
        ATTR_MAP.put(208, FA_EXCHANGE);
        ATTR_MAP.put(209, FA_EXCLAMATION);
        ATTR_MAP.put(210, FA_EXCLAMATION_CIRCLE);
        ATTR_MAP.put(211, FA_EXCLAMATION_TRIANGLE);
        ATTR_MAP.put(212, FA_EXPAND);
        ATTR_MAP.put(213, FA_EXPEDITEDSSL);
        ATTR_MAP.put(214, FA_EXTERNAL_LINK);
        ATTR_MAP.put(215, FA_EXTERNAL_LINK_SQUARE);
        ATTR_MAP.put(216, FA_EYE);
        ATTR_MAP.put(217, FA_EYE_SLASH);
        ATTR_MAP.put(218, FA_EYEDROPPER);
        ATTR_MAP.put(219, FA_FACEBOOK);
        ATTR_MAP.put(220, FA_FACEBOOK_F);
        ATTR_MAP.put(221, FA_FACEBOOK_OFFICIAL);
        ATTR_MAP.put(222, FA_FACEBOOK_SQUARE);
        ATTR_MAP.put(223, FA_FAST_BACKWARD);
        ATTR_MAP.put(224, FA_FAST_FORWARD);
        ATTR_MAP.put(225, FA_FAX);
        ATTR_MAP.put(226, FA_FEED);
        ATTR_MAP.put(227, FA_FEMALE);
        ATTR_MAP.put(228, FA_FIGHTER_JET);
        ATTR_MAP.put(229, FA_FILE);
        ATTR_MAP.put(230, FA_FILE_ARCHIVE_O);
        ATTR_MAP.put(231, FA_FILE_AUDIO_O);
        ATTR_MAP.put(232, FA_FILE_CODE_O);
        ATTR_MAP.put(233, FA_FILE_EXCEL_O);
        ATTR_MAP.put(234, FA_FILE_IMAGE_O);
        ATTR_MAP.put(235, FA_FILE_MOVIE_O);
        ATTR_MAP.put(236, FA_FILE_O);
        ATTR_MAP.put(237, FA_FILE_PDF_O);
        ATTR_MAP.put(238, FA_FILE_PHOTO_O);
        ATTR_MAP.put(239, FA_FILE_PICTURE_O);
        ATTR_MAP.put(240, FA_FILE_POWERPOINT_O);
        ATTR_MAP.put(241, FA_FILE_SOUND_O);
        ATTR_MAP.put(242, FA_FILE_TEXT);
        ATTR_MAP.put(243, FA_FILE_TEXT_O);
        ATTR_MAP.put(244, FA_FILE_VIDEO_O);
        ATTR_MAP.put(245, FA_FILE_WORD_O);
        ATTR_MAP.put(246, FA_FILE_ZIP_O);
        ATTR_MAP.put(247, FA_FILES_O);
        ATTR_MAP.put(248, FA_FILM);
        ATTR_MAP.put(249, FA_FILTER);
        ATTR_MAP.put(250, FA_FIRE);
        ATTR_MAP.put(251, FA_FIRE_EXTINGUISHER);
        ATTR_MAP.put(252, FA_FIREFOX);
        ATTR_MAP.put(253, FA_FLAG);
        ATTR_MAP.put(254, FA_FLAG_CHECKERED);
        ATTR_MAP.put(255, FA_FLAG_O);
        ATTR_MAP.put(256, FA_FLASH);
        ATTR_MAP.put(257, FA_FLASK);
        ATTR_MAP.put(258, FA_FLICKR);
        ATTR_MAP.put(259, FA_FLOPPY_O);
        ATTR_MAP.put(260, FA_FOLDER);
        ATTR_MAP.put(261, FA_FOLDER_O);
        ATTR_MAP.put(262, FA_FOLDER_OPEN);
        ATTR_MAP.put(263, FA_FOLDER_OPEN_O);
        ATTR_MAP.put(264, FA_FONT);
        ATTR_MAP.put(265, FA_FONTICONS);
        ATTR_MAP.put(266, FA_FORT_AWESOME);
        ATTR_MAP.put(267, FA_FORUMBEE);
        ATTR_MAP.put(268, FA_FORWARD);
        ATTR_MAP.put(269, FA_FOURSQUARE);
        ATTR_MAP.put(270, FA_FROWN_O);
        ATTR_MAP.put(271, FA_FUTBOL_O);
        ATTR_MAP.put(272, FA_GAMEPAD);
        ATTR_MAP.put(273, FA_GAVEL);
        ATTR_MAP.put(274, FA_GBP);
        ATTR_MAP.put(275, FA_GE);
        ATTR_MAP.put(276, FA_GEAR);
        ATTR_MAP.put(277, FA_GEARS);
        ATTR_MAP.put(278, FA_GENDERLESS);
        ATTR_MAP.put(279, FA_GET_POCKET);
        ATTR_MAP.put(280, FA_GG);
        ATTR_MAP.put(281, FA_GG_CIRCLE);
        ATTR_MAP.put(282, FA_GIFT);
        ATTR_MAP.put(283, FA_GIT);
        ATTR_MAP.put(284, FA_GIT_SQUARE);
        ATTR_MAP.put(285, FA_GITHUB);
        ATTR_MAP.put(286, FA_GITHUB_ALT);
        ATTR_MAP.put(287, FA_GITHUB_SQUARE);
        ATTR_MAP.put(288, FA_GITTIP);
        ATTR_MAP.put(289, FA_GLASS);
        ATTR_MAP.put(290, FA_GLOBE);
        ATTR_MAP.put(291, FA_GOOGLE);
        ATTR_MAP.put(292, FA_GOOGLE_PLUS);
        ATTR_MAP.put(293, FA_GOOGLE_PLUS_SQUARE);
        ATTR_MAP.put(294, FA_GOOGLE_WALLET);
        ATTR_MAP.put(295, FA_GRADUATION_CAP);
        ATTR_MAP.put(296, FA_GRATIPAY);
        ATTR_MAP.put(297, FA_GROUP);
        ATTR_MAP.put(298, FA_H_SQUARE);
        ATTR_MAP.put(299, FA_HACKER_NEWS);
        ATTR_MAP.put(300, FA_HAND_GRAB_O);
        ATTR_MAP.put(301, FA_HAND_LIZARD_O);
        ATTR_MAP.put(302, FA_HAND_O_DOWN);
        ATTR_MAP.put(303, FA_HAND_O_LEFT);
        ATTR_MAP.put(304, FA_HAND_O_RIGHT);
        ATTR_MAP.put(305, FA_HAND_O_UP);
        ATTR_MAP.put(306, FA_HAND_PAPER_O);
        ATTR_MAP.put(307, FA_HAND_PEACE_O);
        ATTR_MAP.put(308, FA_HAND_POINTER_O);
        ATTR_MAP.put(309, FA_HAND_ROCK_O);
        ATTR_MAP.put(310, FA_HAND_SCISSORS_O);
        ATTR_MAP.put(311, FA_HAND_SPOCK_O);
        ATTR_MAP.put(312, FA_HAND_STOP_O);
        ATTR_MAP.put(313, FA_HASHTAG);
        ATTR_MAP.put(314, FA_HDD_O);
        ATTR_MAP.put(315, FA_HEADER);
        ATTR_MAP.put(316, FA_HEADPHONES);
        ATTR_MAP.put(317, FA_HEART);
        ATTR_MAP.put(318, FA_HEART_O);
        ATTR_MAP.put(319, FA_HEARTBEAT);
        ATTR_MAP.put(320, FA_HISTORY);
        ATTR_MAP.put(321, FA_HOME);
        ATTR_MAP.put(322, FA_HOSPITAL_O);
        ATTR_MAP.put(323, FA_HOTEL);
        ATTR_MAP.put(324, FA_HOURGLASS);
        ATTR_MAP.put(325, FA_HOURGLASS_1);
        ATTR_MAP.put(326, FA_HOURGLASS_2);
        ATTR_MAP.put(327, FA_HOURGLASS_3);
        ATTR_MAP.put(328, FA_HOURGLASS_END);
        ATTR_MAP.put(329, FA_HOURGLASS_HALF);
        ATTR_MAP.put(330, FA_HOURGLASS_O);
        ATTR_MAP.put(331, FA_HOURGLASS_START);
        ATTR_MAP.put(332, FA_HOUZZ);
        ATTR_MAP.put(333, FA_HTML5);
        ATTR_MAP.put(334, FA_I_CURSOR);
        ATTR_MAP.put(335, FA_ILS);
        ATTR_MAP.put(336, FA_IMAGE);
        ATTR_MAP.put(337, FA_INBOX);
        ATTR_MAP.put(338, FA_INDENT);
        ATTR_MAP.put(339, FA_INDUSTRY);
        ATTR_MAP.put(340, FA_INFO);
        ATTR_MAP.put(341, FA_INFO_CIRCLE);
        ATTR_MAP.put(342, FA_INR);
        ATTR_MAP.put(343, FA_INSTAGRAM);
        ATTR_MAP.put(344, FA_INSTITUTION);
        ATTR_MAP.put(345, FA_INTERNET_EXPLORER);
        ATTR_MAP.put(346, FA_INTERSEX);
        ATTR_MAP.put(347, FA_IOXHOST);
        ATTR_MAP.put(348, FA_ITALIC);
        ATTR_MAP.put(349, FA_JOOMLA);
        ATTR_MAP.put(350, FA_JPY);
        ATTR_MAP.put(351, FA_JSFIDDLE);
        ATTR_MAP.put(352, FA_KEY);
        ATTR_MAP.put(353, FA_KEYBOARD_O);
        ATTR_MAP.put(354, FA_KRW);
        ATTR_MAP.put(355, FA_LANGUAGE);
        ATTR_MAP.put(356, FA_LAPTOP);
        ATTR_MAP.put(357, FA_LASTFM);
        ATTR_MAP.put(358, FA_LASTFM_SQUARE);
        ATTR_MAP.put(359, FA_LEAF);
        ATTR_MAP.put(360, FA_LEANPUB);
        ATTR_MAP.put(361, FA_LEGAL);
        ATTR_MAP.put(362, FA_LEMON_O);
        ATTR_MAP.put(363, FA_LEVEL_DOWN);
        ATTR_MAP.put(364, FA_LEVEL_UP);
        ATTR_MAP.put(365, FA_LIFE_BOUY);
        ATTR_MAP.put(366, FA_LIFE_BUOY);
        ATTR_MAP.put(367, FA_LIFE_RING);
        ATTR_MAP.put(368, FA_LIFE_SAVER);
        ATTR_MAP.put(369, FA_LIGHTBULB_O);
        ATTR_MAP.put(370, FA_LINE_CHART);
        ATTR_MAP.put(371, FA_LINK);
        ATTR_MAP.put(372, FA_LINKEDIN);
        ATTR_MAP.put(373, FA_LINKEDIN_SQUARE);
        ATTR_MAP.put(374, FA_LINUX);
        ATTR_MAP.put(375, FA_LIST);
        ATTR_MAP.put(376, FA_LIST_ALT);
        ATTR_MAP.put(377, FA_LIST_OL);
        ATTR_MAP.put(378, FA_LIST_UL);
        ATTR_MAP.put(379, FA_LOCATION_ARROW);
        ATTR_MAP.put(380, FA_LOCK);
        ATTR_MAP.put(381, FA_LONG_ARROW_DOWN);
        ATTR_MAP.put(382, FA_LONG_ARROW_LEFT);
        ATTR_MAP.put(383, FA_LONG_ARROW_RIGHT);
        ATTR_MAP.put(384, FA_LONG_ARROW_UP);
        ATTR_MAP.put(385, FA_MAGIC);
        ATTR_MAP.put(386, FA_MAGNET);
        ATTR_MAP.put(387, FA_MAIL_FORWARD);
        ATTR_MAP.put(388, FA_MAIL_REPLY);
        ATTR_MAP.put(389, FA_MAIL_REPLY_ALL);
        ATTR_MAP.put(390, FA_MALE);
        ATTR_MAP.put(391, FA_MAP);
        ATTR_MAP.put(392, FA_MAP_MARKER);
        ATTR_MAP.put(393, FA_MAP_O);
        ATTR_MAP.put(394, FA_MAP_PIN);
        ATTR_MAP.put(395, FA_MAP_SIGNS);
        ATTR_MAP.put(396, FA_MARS);
        ATTR_MAP.put(397, FA_MARS_DOUBLE);
        ATTR_MAP.put(398, FA_MARS_STROKE);
        ATTR_MAP.put(399, FA_MARS_STROKE_H);
        ATTR_MAP.put(400, FA_MARS_STROKE_V);
        ATTR_MAP.put(401, FA_MAXCDN);
        ATTR_MAP.put(402, FA_MEANPATH);
        ATTR_MAP.put(403, FA_MEDIUM);
        ATTR_MAP.put(404, FA_MEDKIT);
        ATTR_MAP.put(405, FA_MEH_O);
        ATTR_MAP.put(406, FA_MERCURY);
        ATTR_MAP.put(407, FA_MICROPHONE);
        ATTR_MAP.put(408, FA_MICROPHONE_SLASH);
        ATTR_MAP.put(409, FA_MINUS);
        ATTR_MAP.put(410, FA_MINUS_CIRCLE);
        ATTR_MAP.put(411, FA_MINUS_SQUARE);
        ATTR_MAP.put(412, FA_MINUS_SQUARE_O);
        ATTR_MAP.put(413, FA_MIXCLOUD);
        ATTR_MAP.put(414, FA_MOBILE);
        ATTR_MAP.put(415, FA_MOBILE_PHONE);
        ATTR_MAP.put(416, FA_MODX);
        ATTR_MAP.put(417, FA_MONEY);
        ATTR_MAP.put(418, FA_MOON_O);
        ATTR_MAP.put(419, FA_MORTAR_BOARD);
        ATTR_MAP.put(420, FA_MOTORCYCLE);
        ATTR_MAP.put(421, FA_MOUSE_POINTER);
        ATTR_MAP.put(422, FA_MUSIC);
        ATTR_MAP.put(423, FA_NAVICON);
        ATTR_MAP.put(424, FA_NEUTER);
        ATTR_MAP.put(425, FA_NEWSPAPER_O);
        ATTR_MAP.put(426, FA_OBJECT_GROUP);
        ATTR_MAP.put(427, FA_OBJECT_UNGROUP);
        ATTR_MAP.put(428, FA_ODNOKLASSNIKI);
        ATTR_MAP.put(429, FA_ODNOKLASSNIKI_SQUARE);
        ATTR_MAP.put(430, FA_OPENCART);
        ATTR_MAP.put(431, FA_OPENID);
        ATTR_MAP.put(432, FA_OPERA);
        ATTR_MAP.put(433, FA_OPTIN_MONSTER);
        ATTR_MAP.put(434, FA_OUTDENT);
        ATTR_MAP.put(435, FA_PAGELINES);
        ATTR_MAP.put(436, FA_PAINT_BRUSH);
        ATTR_MAP.put(437, FA_PAPER_PLANE);
        ATTR_MAP.put(438, FA_PAPER_PLANE_O);
        ATTR_MAP.put(439, FA_PAPERCLIP);
        ATTR_MAP.put(440, FA_PARAGRAPH);
        ATTR_MAP.put(441, FA_PASTE);
        ATTR_MAP.put(442, FA_PAUSE);
        ATTR_MAP.put(443, FA_PAUSE_CIRCLE);
        ATTR_MAP.put(444, FA_PAUSE_CIRCLE_O);
        ATTR_MAP.put(445, FA_PAW);
        ATTR_MAP.put(446, FA_PAYPAL);
        ATTR_MAP.put(447, FA_PENCIL);
        ATTR_MAP.put(448, FA_PENCIL_SQUARE);
        ATTR_MAP.put(449, FA_PENCIL_SQUARE_O);
        ATTR_MAP.put(450, FA_PERCENT);
        ATTR_MAP.put(451, FA_PHONE);
        ATTR_MAP.put(452, FA_PHONE_SQUARE);
        ATTR_MAP.put(453, FA_PHOTO);
        ATTR_MAP.put(454, FA_PICTURE_O);
        ATTR_MAP.put(455, FA_PIE_CHART);
        ATTR_MAP.put(456, FA_PIED_PIPER);
        ATTR_MAP.put(457, FA_PIED_PIPER_ALT);
        ATTR_MAP.put(458, FA_PINTEREST);
        ATTR_MAP.put(459, FA_PINTEREST_P);
        ATTR_MAP.put(460, FA_PINTEREST_SQUARE);
        ATTR_MAP.put(461, FA_PLANE);
        ATTR_MAP.put(462, FA_PLAY);
        ATTR_MAP.put(463, FA_PLAY_CIRCLE);
        ATTR_MAP.put(464, FA_PLAY_CIRCLE_O);
        ATTR_MAP.put(465, FA_PLUG);
        ATTR_MAP.put(466, FA_PLUS);
        ATTR_MAP.put(467, FA_PLUS_CIRCLE);
        ATTR_MAP.put(468, FA_PLUS_SQUARE);
        ATTR_MAP.put(469, FA_PLUS_SQUARE_O);
        ATTR_MAP.put(470, FA_POWER_OFF);
        ATTR_MAP.put(471, FA_PRINT);
        ATTR_MAP.put(472, FA_PRODUCT_HUNT);
        ATTR_MAP.put(473, FA_PUZZLE_PIECE);
        ATTR_MAP.put(474, FA_QQ);
        ATTR_MAP.put(475, FA_QRCODE);
        ATTR_MAP.put(476, FA_QUESTION);
        ATTR_MAP.put(477, FA_QUESTION_CIRCLE);
        ATTR_MAP.put(478, FA_QUOTE_LEFT);
        ATTR_MAP.put(479, FA_QUOTE_RIGHT);
        ATTR_MAP.put(480, FA_RA);
        ATTR_MAP.put(481, FA_RANDOM);
        ATTR_MAP.put(482, FA_REBEL);
        ATTR_MAP.put(483, FA_RECYCLE);
        ATTR_MAP.put(484, FA_REDDIT);
        ATTR_MAP.put(485, FA_REDDIT_ALIEN);
        ATTR_MAP.put(486, FA_REDDIT_SQUARE);
        ATTR_MAP.put(487, FA_REFRESH);
        ATTR_MAP.put(488, FA_REGISTERED);
        ATTR_MAP.put(489, FA_REMOVE);
        ATTR_MAP.put(490, FA_RENREN);
        ATTR_MAP.put(491, FA_REORDER);
        ATTR_MAP.put(492, FA_REPEAT);
        ATTR_MAP.put(493, FA_REPLY);
        ATTR_MAP.put(494, FA_REPLY_ALL);
        ATTR_MAP.put(495, FA_RETWEET);
        ATTR_MAP.put(496, FA_RMB);
        ATTR_MAP.put(497, FA_ROAD);
        ATTR_MAP.put(498, FA_ROCKET);
        ATTR_MAP.put(499, FA_ROTATE_LEFT);
        ATTR_MAP.put(500, FA_ROTATE_RIGHT);
        ATTR_MAP.put(501, FA_ROUBLE);
        ATTR_MAP.put(502, FA_RSS);
        ATTR_MAP.put(503, FA_RSS_SQUARE);
        ATTR_MAP.put(504, FA_RUB);
        ATTR_MAP.put(505, FA_RUBLE);
        ATTR_MAP.put(506, FA_RUPEE);
        ATTR_MAP.put(507, FA_SAFARI);
        ATTR_MAP.put(508, FA_SAVE);
        ATTR_MAP.put(509, FA_SCISSORS);
        ATTR_MAP.put(510, FA_SCRIBD);
        ATTR_MAP.put(511, FA_SEARCH);
        ATTR_MAP.put(512, FA_SEARCH_MINUS);
        ATTR_MAP.put(513, FA_SEARCH_PLUS);
        ATTR_MAP.put(514, FA_SELLSY);
        ATTR_MAP.put(515, FA_SEND);
        ATTR_MAP.put(516, FA_SEND_O);
        ATTR_MAP.put(517, FA_SERVER);
        ATTR_MAP.put(518, FA_SHARE);
        ATTR_MAP.put(519, FA_SHARE_ALT);
        ATTR_MAP.put(520, FA_SHARE_ALT_SQUARE);
        ATTR_MAP.put(521, FA_SHARE_SQUARE);
        ATTR_MAP.put(522, FA_SHARE_SQUARE_O);
        ATTR_MAP.put(523, FA_SHEKEL);
        ATTR_MAP.put(524, FA_SHEQEL);
        ATTR_MAP.put(525, FA_SHIELD);
        ATTR_MAP.put(526, FA_SHIP);
        ATTR_MAP.put(527, FA_SHIRTSINBULK);
        ATTR_MAP.put(528, FA_SHOPPING_BAG);
        ATTR_MAP.put(529, FA_SHOPPING_BASKET);
        ATTR_MAP.put(530, FA_SHOPPING_CART);
        ATTR_MAP.put(531, FA_SIGN_IN);
        ATTR_MAP.put(532, FA_SIGN_OUT);
        ATTR_MAP.put(533, FA_SIGNAL);
        ATTR_MAP.put(534, FA_SIMPLYBUILT);
        ATTR_MAP.put(535, FA_SITEMAP);
        ATTR_MAP.put(536, FA_SKYATLAS);
        ATTR_MAP.put(537, FA_SKYPE);
        ATTR_MAP.put(538, FA_SLACK);
        ATTR_MAP.put(539, FA_SLIDERS);
        ATTR_MAP.put(540, FA_SLIDESHARE);
        ATTR_MAP.put(541, FA_SMILE_O);
        ATTR_MAP.put(542, FA_SOCCER_BALL_O);
        ATTR_MAP.put(543, FA_SORT);
        ATTR_MAP.put(544, FA_SORT_ALPHA_ASC);
        ATTR_MAP.put(545, FA_SORT_ALPHA_DESC);
        ATTR_MAP.put(546, FA_SORT_AMOUNT_ASC);
        ATTR_MAP.put(547, FA_SORT_AMOUNT_DESC);
        ATTR_MAP.put(548, FA_SORT_ASC);
        ATTR_MAP.put(549, FA_SORT_DESC);
        ATTR_MAP.put(550, FA_SORT_DOWN);
        ATTR_MAP.put(551, FA_SORT_NUMERIC_ASC);
        ATTR_MAP.put(552, FA_SORT_NUMERIC_DESC);
        ATTR_MAP.put(553, FA_SORT_UP);
        ATTR_MAP.put(554, FA_SOUNDCLOUD);
        ATTR_MAP.put(555, FA_SPACE_SHUTTLE);
        ATTR_MAP.put(556, FA_SPINNER);
        ATTR_MAP.put(557, FA_SPOON);
        ATTR_MAP.put(558, FA_SPOTIFY);
        ATTR_MAP.put(559, FA_SQUARE);
        ATTR_MAP.put(560, FA_SQUARE_O);
        ATTR_MAP.put(561, FA_STACK_EXCHANGE);
        ATTR_MAP.put(562, FA_STACK_OVERFLOW);
        ATTR_MAP.put(563, FA_STAR);
        ATTR_MAP.put(564, FA_STAR_HALF);
        ATTR_MAP.put(565, FA_STAR_HALF_EMPTY);
        ATTR_MAP.put(566, FA_STAR_HALF_FULL);
        ATTR_MAP.put(567, FA_STAR_HALF_O);
        ATTR_MAP.put(568, FA_STAR_O);
        ATTR_MAP.put(569, FA_STEAM);
        ATTR_MAP.put(570, FA_STEAM_SQUARE);
        ATTR_MAP.put(571, FA_STEP_BACKWARD);
        ATTR_MAP.put(572, FA_STEP_FORWARD);
        ATTR_MAP.put(573, FA_STETHOSCOPE);
        ATTR_MAP.put(574, FA_STICKY_NOTE);
        ATTR_MAP.put(575, FA_STICKY_NOTE_O);
        ATTR_MAP.put(576, FA_STOP);
        ATTR_MAP.put(577, FA_STOP_CIRCLE);
        ATTR_MAP.put(578, FA_STOP_CIRCLE_O);
        ATTR_MAP.put(579, FA_STREET_VIEW);
        ATTR_MAP.put(580, FA_STRIKETHROUGH);
        ATTR_MAP.put(581, FA_STUMBLEUPON);
        ATTR_MAP.put(582, FA_STUMBLEUPON_CIRCLE);
        ATTR_MAP.put(583, FA_SUBSCRIPT);
        ATTR_MAP.put(584, FA_SUBWAY);
        ATTR_MAP.put(585, FA_SUITCASE);
        ATTR_MAP.put(586, FA_SUN_O);
        ATTR_MAP.put(587, FA_SUPERSCRIPT);
        ATTR_MAP.put(588, FA_SUPPORT);
        ATTR_MAP.put(589, FA_TABLE);
        ATTR_MAP.put(590, FA_TABLET);
        ATTR_MAP.put(591, FA_TACHOMETER);
        ATTR_MAP.put(592, FA_TAG);
        ATTR_MAP.put(593, FA_TAGS);
        ATTR_MAP.put(594, FA_TASKS);
        ATTR_MAP.put(595, FA_TAXI);
        ATTR_MAP.put(596, FA_TELEVISION);
        ATTR_MAP.put(597, FA_TENCENT_WEIBO);
        ATTR_MAP.put(598, FA_TERMINAL);
        ATTR_MAP.put(599, FA_TEXT_HEIGHT);
        ATTR_MAP.put(600, FA_TEXT_WIDTH);
        ATTR_MAP.put(601, FA_TH);
        ATTR_MAP.put(602, FA_TH_LARGE);
        ATTR_MAP.put(603, FA_TH_LIST);
        ATTR_MAP.put(604, FA_THUMB_TACK);
        ATTR_MAP.put(605, FA_THUMBS_DOWN);
        ATTR_MAP.put(606, FA_THUMBS_O_DOWN);
        ATTR_MAP.put(607, FA_THUMBS_O_UP);
        ATTR_MAP.put(608, FA_THUMBS_UP);
        ATTR_MAP.put(609, FA_TICKET);
        ATTR_MAP.put(610, FA_TIMES);
        ATTR_MAP.put(611, FA_TIMES_CIRCLE);
        ATTR_MAP.put(612, FA_TIMES_CIRCLE_O);
        ATTR_MAP.put(613, FA_TINT);
        ATTR_MAP.put(614, FA_TOGGLE_DOWN);
        ATTR_MAP.put(615, FA_TOGGLE_LEFT);
        ATTR_MAP.put(616, FA_TOGGLE_OFF);
        ATTR_MAP.put(617, FA_TOGGLE_ON);
        ATTR_MAP.put(618, FA_TOGGLE_RIGHT);
        ATTR_MAP.put(619, FA_TOGGLE_UP);
        ATTR_MAP.put(620, FA_TRADEMARK);
        ATTR_MAP.put(621, FA_TRAIN);
        ATTR_MAP.put(622, FA_TRANSGENDER);
        ATTR_MAP.put(623, FA_TRANSGENDER_ALT);
        ATTR_MAP.put(624, FA_TRASH);
        ATTR_MAP.put(625, FA_TRASH_O);
        ATTR_MAP.put(626, FA_TREE);
        ATTR_MAP.put(627, FA_TRELLO);
        ATTR_MAP.put(628, FA_TRIPADVISOR);
        ATTR_MAP.put(629, FA_TROPHY);
        ATTR_MAP.put(630, FA_TRUCK);
        ATTR_MAP.put(631, FA_TRY);
        ATTR_MAP.put(632, FA_TTY);
        ATTR_MAP.put(633, FA_TUMBLR);
        ATTR_MAP.put(634, FA_TUMBLR_SQUARE);
        ATTR_MAP.put(635, FA_TURKISH_LIRA);
        ATTR_MAP.put(636, FA_TV);
        ATTR_MAP.put(637, FA_TWITCH);
        ATTR_MAP.put(638, FA_TWITTER);
        ATTR_MAP.put(639, FA_TWITTER_SQUARE);
        ATTR_MAP.put(640, FA_UMBRELLA);
        ATTR_MAP.put(641, FA_UNDERLINE);
        ATTR_MAP.put(642, FA_UNDO);
        ATTR_MAP.put(643, FA_UNIVERSITY);
        ATTR_MAP.put(644, FA_UNLINK);
        ATTR_MAP.put(645, FA_UNLOCK);
        ATTR_MAP.put(646, FA_UNLOCK_ALT);
        ATTR_MAP.put(647, FA_UNSORTED);
        ATTR_MAP.put(648, FA_UPLOAD);
        ATTR_MAP.put(649, FA_USB);
        ATTR_MAP.put(650, FA_USD);
        ATTR_MAP.put(651, FA_USER);
        ATTR_MAP.put(652, FA_USER_MD);
        ATTR_MAP.put(653, FA_USER_PLUS);
        ATTR_MAP.put(654, FA_USER_SECRET);
        ATTR_MAP.put(655, FA_USER_TIMES);
        ATTR_MAP.put(656, FA_USERS);
        ATTR_MAP.put(657, FA_VENUS);
        ATTR_MAP.put(658, FA_VENUS_DOUBLE);
        ATTR_MAP.put(659, FA_VENUS_MARS);
        ATTR_MAP.put(660, FA_VIACOIN);
        ATTR_MAP.put(661, FA_VIDEO_CAMERA);
        ATTR_MAP.put(662, FA_VIMEO);
        ATTR_MAP.put(663, FA_VIMEO_SQUARE);
        ATTR_MAP.put(664, FA_VINE);
        ATTR_MAP.put(665, FA_VK);
        ATTR_MAP.put(666, FA_VOLUME_DOWN);
        ATTR_MAP.put(667, FA_VOLUME_OFF);
        ATTR_MAP.put(668, FA_VOLUME_UP);
        ATTR_MAP.put(669, FA_WARNING);
        ATTR_MAP.put(670, FA_WECHAT);
        ATTR_MAP.put(671, FA_WEIBO);
        ATTR_MAP.put(672, FA_WEIXIN);
        ATTR_MAP.put(673, FA_WHATSAPP);
        ATTR_MAP.put(674, FA_WHEELCHAIR);
        ATTR_MAP.put(675, FA_WIFI);
        ATTR_MAP.put(676, FA_WIKIPEDIA_W);
        ATTR_MAP.put(677, FA_WINDOWS);
        ATTR_MAP.put(678, FA_WON);
        ATTR_MAP.put(679, FA_WORDPRESS);
        ATTR_MAP.put(680, FA_WRENCH);
        ATTR_MAP.put(681, FA_XING);
        ATTR_MAP.put(682, FA_XING_SQUARE);
        ATTR_MAP.put(683, FA_Y_COMBINATOR);
        ATTR_MAP.put(684, FA_Y_COMBINATOR_SQUARE);
        ATTR_MAP.put(685, FA_YAHOO);
        ATTR_MAP.put(686, FA_YC);
        ATTR_MAP.put(687, FA_YC_SQUARE);
        ATTR_MAP.put(688, FA_YELP);
        ATTR_MAP.put(689, FA_YEN);
        ATTR_MAP.put(690, FA_YOUTUBE);
        ATTR_MAP.put(691, FA_YOUTUBE_PLAY);
        ATTR_MAP.put(692, FA_YOUTUBE_SQUARE);
    }

}
