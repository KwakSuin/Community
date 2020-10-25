package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class QuestDataBase {
    /**
     * TAG for debugging
     */
    public static final String TAG = "QuestDataBase";

    /**
     * Singleton instance
     */
    private static QuestDataBase database;


    /**
     * database name
     */
    public static String DATABASE_NAME = "quest.db";

    /**
     * table name for QUEST_INFO
     */
    public static String TABLE_QUEST_INFO = "QUEST_INFO";

    /**
     * version
     */
    public static int DATABASE_VERSION = 1;


    /**
     * Helper class defined
     */
    private DatabaseHelper dbHelper;

    /**
     * Database object
     */
    private SQLiteDatabase db;


    private Context context;

    /**
     * Constructor
     */
    private QuestDataBase(Context context) {
        this.context = context;
    }


    public static QuestDataBase getInstance(Context context) {
        if (database == null) {
            database = new QuestDataBase(context);
        }

        return database;
    }

    /**
     * open database
     *
     * @return
     */
    public boolean open() {
        println("opening database [" + DATABASE_NAME + "].");

        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    /**
     * close database
     */
    public void close() {
        println("closing database [" + DATABASE_NAME + "].");
        db.close();
        database = null;
    }

    public Cursor rawQuery(String SQL) {
        println("\nexecuteQuery called.\n");

        Cursor c1 = null;
        try {
            c1 = db.rawQuery(SQL, null);
            println("cursor count : " + c1.getCount());
        } catch(Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
        }

        return c1;
    }

    public boolean execSQL(String SQL) {
        println("\nexecute called.\n");

        try {
            Log.d(TAG, "SQL : " + SQL);
            db.execSQL(SQL);
        } catch(Exception ex) {
            Log.e(TAG, "Exception in executeQuery", ex);
            return false;
        }

        return true;
    }




    private class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase _db) {
            // TABLE_QUEST_INFO
            println("creating table [" + TABLE_QUEST_INFO + "].");

            // drop existing table
            String DROP_SQL = "drop table if exists " + TABLE_QUEST_INFO;
            try {
                _db.execSQL(DROP_SQL);
            } catch(Exception ex) {
                Log.e(TAG, "Exception in DROP_SQL", ex);
            }

            // create table
            String CREATE_SQL = "create table " + TABLE_QUEST_INFO + "("
                    + "  _id INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + "  TITLE TEXT, "
                    + "  NAME TEXT, "
                    + "  CONTENTS TEXT, "
                    + "  CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP "
                    + ")";
            try {
                _db.execSQL(CREATE_SQL);
            } catch(Exception ex) {
                Log.e(TAG, "Exception in CREATE_SQL", ex);
            }

            // insert 3 quest records
            insertRecord(_db, "질문합니다.", "치와와", "치와와 간식 추천해주세요.");
            insertRecord(_db, "중성화수술", "Mike", "다들 중성화 수술 언제하셨나요?");
            insertRecord(_db, "장난감 추천", "모모주인", "강아지 장난감 추천해주세요!");
            //insertRecord(_db, "시작하세요! 안드로이드 게임 프로그래밍", "마리오 제흐너 저", "위키북스에서 2011년 09월에 출판했습니다.");
            //insertRecord(_db, "실전! 안드로이드 시스템 프로그래밍 완전정복", "박선호,오영환 공저", "DW Wave에서 2010년 10월에 출판했습니다.");

        }

        public void onOpen(SQLiteDatabase db) {
            println("opened database [" + DATABASE_NAME + "].");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            println("Upgrading database from version " + oldVersion + " to " + newVersion + ".");

            if (oldVersion < 2) {   // version 1

            }

        }

        private void insertRecord(SQLiteDatabase _db, String title, String name, String contents) {
            try {
                _db.execSQL( "insert into " + TABLE_QUEST_INFO + "(TITLE, NAME, CONTENTS) values ('" + title + "', '" + name + "', '" + contents + "');" );
            } catch(Exception ex) {
                Log.e(TAG, "Exception in executing insert SQL.", ex);
            }
        }

    }

    public void insertRecord(String title, String name, String contents) {
        try {
            db.execSQL( "insert into " + TABLE_QUEST_INFO + "(TITLE, NAME, CONTENTS) values ('" + title + "', '" + name + "', '" + contents + "');" );
        } catch(Exception ex) {
            Log.e(TAG, "Exception in executing insert SQL.", ex);
        }
    }

    public ArrayList<QuestInfo> selectAll() {
        ArrayList<QuestInfo> result = new ArrayList<QuestInfo>();

        try {
            Cursor cursor = db.rawQuery("select TITLE, NAME, CONTENTS from " + TABLE_QUEST_INFO, null);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String title = cursor.getString(0);
                String name = cursor.getString(1);
                String contents = cursor.getString(2);

                QuestInfo info = new QuestInfo(title, name, contents);
                result.add(info);
            }

        } catch(Exception ex) {
            Log.e(TAG, "Exception in executing insert SQL.", ex);
        }

        return result;
    }

    private void println(String msg) {
        Log.d(TAG, msg);
    }
}
