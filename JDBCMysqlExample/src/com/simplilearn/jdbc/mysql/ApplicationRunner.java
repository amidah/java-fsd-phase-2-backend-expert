package com.simplilearn.jdbc.mysql;

public class ApplicationRunner {

	public static void main(String[] args) {

		MysqlConnection msc = new MysqlConnection();
		msc.performJdbcConnectivity();

		SimpleTransactionExample st = new SimpleTransactionExample();
		st.simpleTxMgmt();

		PreparedStatementTransactionMgmt pstm = new PreparedStatementTransactionMgmt();
		pstm.txMgmtUsingPreparedStmt();

		BatchExecution be = new BatchExecution();
		be.runBatchExecution();
	}
}
