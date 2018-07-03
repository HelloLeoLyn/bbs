﻿package cms.bean.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


/**
 * 用户管理
 *
 */
@Entity
@Table(name="user",uniqueConstraints = {
		@UniqueConstraint(columnNames={"userName"}
   )},indexes = {@Index(name="user_idx", columnList="state")}
)//给user字段添加唯一性约束
public class User implements Serializable{
	private static final long serialVersionUID = 3692366870616346904L;
	
	/** ID **/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 会员用户名 **/
	@Column(length=30)
	private String userName;
	/** 密码 密码结构: sha256(sha256(密码)+[盐值])  **/
	@Column(length=160)
	private String password;
	/** 盐值 **/
	@Column(length=80)
	private String salt;
	
	
	/** 安全摘要 需要用户重新登录时改变此值**/
	private Long securityDigest;
	
	/** 邮箱地址 **/
	@Column(length=60)
	private String email;
	/** 密码提示问题 **/
	@Column(length=50)
	private String issue;
	/** 密码提示答案 **/
	@Column(length=80)
	private String answer;
	/** 绑定手机 **/
	@Column(length=20)
	private String mobile;
	/** 是否实名认证 **/
	private boolean realNameAuthentication = false;

	/** 注册日期 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	/** 备注 **/
	@Lob 
	private String remarks;
	/** 当前积分**/
	private Long point = 0L;
	
	
	/** 用户状态    1:正常用户   2:禁止用户   11: 正常用户删除   12: 禁止用户删除 **/
	private Integer state = 1;
	/** 用户版本号 **/
	private Integer userVersion = 0;
	

	/** 当前等级ID  只用于统计显示,不写入数据库**/
	@Transient
	private Integer gradeId;
	/** 当前等级  只用于统计显示,不写入数据库**/
	@Transient
	private String gradeName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Long getPoint() {
		return point;
	}
	public void setPoint(Long point) {
		this.point = point;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getUserVersion() {
		return userVersion;
	}
	public void setUserVersion(Integer userVersion) {
		this.userVersion = userVersion;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isRealNameAuthentication() {
		return realNameAuthentication;
	}
	public void setRealNameAuthentication(boolean realNameAuthentication) {
		this.realNameAuthentication = realNameAuthentication;
	}
	public Long getSecurityDigest() {
		return securityDigest;
	}
	public void setSecurityDigest(Long securityDigest) {
		this.securityDigest = securityDigest;
	}

}
