package com.kele.resourcenotebusiness.configuration;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * mybatis-plus 自动生成代码类
 */
public class CodeGenerator extends AbstractTemplateEngine {
    public static void main(String[] args) {
        //填写包名
        String packageName = "com.kele.resourcenotebusiness";
        //表名
        generateByTables(packageName, "share");
    }

    /**
     * mysql
     *
     * @param packageName
     * @param tableNames
     */
    private static void generateByTables(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        //数据库名
        String dbUrl = "jdbc:mysql://127.0.0.1:23308/resource-note-business";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("localDocker@mysql")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(true)
//                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
//                .setSuperEntityClass("com.cloud.common.models.BaseCommonVo")
                .setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper")
                .setRestControllerStyle(true)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("gaofangye")
                //填写自己的java路径
                .setOutputDir("C:\\dev\\workspace\\personalSpace\\mini\\mini-resource-note\\resource-note-business\\src\\main\\java")
                .setFileOverride(true);
        config.setMapperName("%sDao");
        config.setXmlName("%sDao");
        config.setEntityName("%s");
        config.setBaseResultMap(true); //生成resultMap
        config.setBaseColumnList(true);//在xml中生成基础列
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName);
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setEntity("domain.entity.share");
        packageConfig.setMapper("dao");
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        autoGenerator.setCfg(
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<String, Object>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(
                        Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                            // 自定义输出文件目录
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return "C:\\dev\\workspace\\personalSpace\\mini\\mini-resource-note\\resource-note-business\\src\\main\\resources\\mybatis-mappers\\" + tableInfo.getEntityName() + "Dao.xml";
                            }
                        }))).setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                        .setEntity("templates/entity.java.vm"));
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
    }

    @Override
    public void writer(Map<String, Object> map, String s, String s1) throws Exception {

    }

    @Override
    public String templateFilePath(String s) {
        return null;
    }
}
