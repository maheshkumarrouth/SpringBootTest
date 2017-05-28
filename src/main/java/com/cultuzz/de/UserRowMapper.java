package com.cultuzz.de;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<TokenData>{

	public TokenData mapRow(ResultSet arg0, int arg1) throws SQLException {
		TokenData tokenData = new TokenData();
		tokenData.setCardData(arg0.getString("cardData"));
		tokenData.setToken(arg0.getString("token"));
		return tokenData;
	}

}
