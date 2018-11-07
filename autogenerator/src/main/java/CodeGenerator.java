import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class CodeGenerator
 * function:
 *
 * @Author chens
 * @Date 2018/10/16 16:03
 */
public class CodeGenerator {

	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);

		StringBuilder help = new StringBuilder();

		help.append("请输入" + tip + ":");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("tip error");

	}

	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();

		com.baomidou.mybatisplus.generator.config.GlobalConfig gc = new GlobalConfig();

		String projectPath = System.getProperty("user.dir");

		gc.setOutputDir(projectPath + "/autogenerator/src/main/java");
		gc.setAuthor("jobob");
		gc.setOpen(false);
		mpg.setGlobalConfig(gc);


		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://localhost:3306/world?useUnicode=true&useSSL=false&characterEncoding=utf8");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("111111");
		mpg.setDataSource(dsc);

		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setModuleName(scanner("模块名"));
		packageConfig.setParent("com.baomidou.ant");
		mpg.setPackageInfo(packageConfig);


		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {

			}
		};


		List<FileOutConfig> focList = new ArrayList<>();

		focList.add(new FileOutConfig("/templates/mapper.xml.ftl"){

			@Override
			public String outputFile(TableInfo tableInfo) {
				return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});


		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);


		mpg.setTemplate(new TemplateConfig().setXml(null));

		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setNaming(NamingStrategy.underline_to_camel);
		strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
		strategyConfig.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategyConfig.setEntityLombokModel(true);
		strategyConfig.setRestControllerStyle(true);
		strategyConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		strategyConfig.setInclude(scanner("表名"));
		strategyConfig.setSuperEntityColumns("id");
		strategyConfig.setControllerMappingHyphenStyle(true);
		strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");
		mpg.setStrategy(strategyConfig);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();


	}
}
