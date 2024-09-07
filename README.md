# simplecaptcha-spring-boot-starter


### 说明

 > 基于 [Simplecaptcha ](http://simplecaptcha.sourceforge.net/) 验证码开源项目实现的验证码 Spring Boot Starter 实现



1. SimpleCaptchaServlet、ChineseCaptchaServlet、StickyCaptchaServlet 自动注册

### Maven Dependency

``` xml
<dependency>
	<groupId>com.github.hiwepy</groupId>
	<artifactId>simplecaptcha-spring-boot-starter</artifactId>
	<version>${project.version}</version>
</dependency>
```

### Usage

#### Step 1 ：Copy 1.1.1.Final-gatein-4 directory

> Copy 1.1.1.Final-gatein-4 to D:\

#### Step 2 ：Deploy  Simplecaptcha Jar Files to Maven Repository

```bash
mvn deploy:deploy-file -DgroupId=org.gatein.captcha -DartifactId=simplecaptcha -Dversion=1.1.1.Final-gatein-4 -Dpackaging=jar -Dfile=D:\1.1.1.Final-gatein-4\simplecaptcha-1.1.1.Final-gatein-4.jar -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
mvn deploy:deploy-file -DgroupId=org.gatein.captcha -DartifactId=simplecaptcha -Dversion=1.1.1.Final-gatein-4 -Dpackaging=jar -Dfile=D:\1.1.1.Final-gatein-4\simplecaptcha-1.1.1.Final-gatein-4-sources.jar -Dclassifier=sources -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
mvn deploy:deploy-file -DgroupId=org.gatein.captcha -DartifactId=simplecaptcha -Dversion=1.1.1.Final-gatein-4 -Dpackaging=pom -Dfile=D:\1.1.1.Final-gatein-4\simplecaptcha-1.1.1.Final-gatein-4.pom -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
```
