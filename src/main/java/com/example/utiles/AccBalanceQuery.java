package com.example.utiles;


import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class AccBalanceQuery {


    public static void main(String[] args) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT " +
                "(SELECT name FROM tb_union_merchant m WHERE m.id=acc.cid ) '店铺名称'" +
                ",acc.acct_no '账号'" +
                ",bind.ex_acct_rn '账户户主名称' " +
                "FROM `tb_cus_virtual_account` acc " +
                "LEFT JOIN tb_cus_bind_card_msg bind " +
                "ON acc.bindid=bind.bindid " +
                "WHERE acc.acct_no ='9100001101000053380'";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
    }


}
