package com.example.multicinema.configurations;

import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.JDBCException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.spi.SQLExceptionConversionDelegate;
import org.hibernate.internal.util.JdbcExceptionHelper;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

/**
 * SQLite dialect for hibernate 5.
 */
public class SQLiteDialect extends Dialect {
    public SQLiteDialect() {
        registerColumnType(Types.BIT, "boolean");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric($p, $s)");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "datetime");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "boolean");

        registerFunction("concat", new VarArgsSQLFunction(StandardBasicTypes.STRING, "", "||", ""));
        registerFunction("mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "?1 % ?2"));
        registerFunction("quote", new StandardSQLFunction("quote", StandardBasicTypes.STRING));
        registerFunction("random", new NoArgSQLFunction("random", StandardBasicTypes.INTEGER));
        registerFunction("round", new StandardSQLFunction("round"));
        registerFunction("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
        registerFunction("trim", new AbstractAnsiTrimEmulationFunction() {
            protected SQLFunction resolveBothSpaceTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1)");
            }

            protected SQLFunction resolveBothSpaceTrimFromFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?2)");
            }

            protected SQLFunction resolveLeadingSpaceTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1)");
            }

            protected SQLFunction resolveTrailingSpaceTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1)");
            }

            protected SQLFunction resolveBothTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1, ?2)");
            }

            protected SQLFunction resolveLeadingTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1, ?2)");
            }

            protected SQLFunction resolveTrailingTrimFunction() {
                return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1, ?2)");
            }
        });
    }

    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }
    private static final int SQLITE_BUSY = 5;
    private static final int SQLITE_LOCKED = 6;
    private static final int SQLITE_IOERR = 10;
    private static final int SQLITE_CORRUPT = 11;
    private static final int SQLITE_NOTFOUND = 12;
    private static final int SQLITE_FULL = 13;
    private static final int SQLITE_CANTOPEN = 14;
    private static final int SQLITE_PROTOCOL = 15;
    private static final int SQLITE_TOOBIG = 18;
    private static final int SQLITE_CONSTRAINT = 19;
    private static final int SQLITE_MISMATCH = 20;
    private static final int SQLITE_NOTADB = 26;

    @Override
    public SQLExceptionConversionDelegate buildSQLExceptionConversionDelegate() {
        return new SQLExceptionConversionDelegate() {
            @Override
            public JDBCException convert(SQLException sqlException, String message, String sql) {
                final int errorCode = JdbcExceptionHelper.extractErrorCode( sqlException );
                if (errorCode == SQLITE_TOOBIG || errorCode == SQLITE_MISMATCH) {
                    return new DataException( message, sqlException, sql );
                }
                else if (errorCode == SQLITE_BUSY || errorCode == SQLITE_LOCKED) {
                    return new LockAcquisitionException( message, sqlException, sql );
                }
                else if ((errorCode >= SQLITE_IOERR && errorCode <= SQLITE_PROTOCOL) || errorCode == SQLITE_NOTADB) {
                    return new JDBCConnectionException( message, sqlException, sql );
                }

                // returning null allows other delegates to operate
                return null;
            }
        };
    }

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public String getForUpdateString() {
        return "";
    }

    @Override
    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    @Override
    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
                                                   String[] primaryKey, boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsTupleDistinctCounts() {
        return false;
    }

    @Override
    public String getSelectGUIDString() {
        return "select hex(randomblob(16))";
    }
}