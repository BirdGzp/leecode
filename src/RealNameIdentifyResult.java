/**
 * @Program: epay
 * @Description: 实名认证结果枚举
 * @ClassName: RealNameIdentifyResult
 * @Author: YangZengguang
 * @Create: 2020/2/18 20:29
 * @Version： V1.0
 **/
public enum RealNameIdentifyResult
{

	SUCCESS("姓名和身份证号码校验成功"),
    FAILED("您的姓名和身份证号码不匹配，请修改"),
    EXCEED("您今日尝试次数受限，请明日再试"),
    ERROR("网络繁忙，请稍后再试"),
    BLACK("证件号码存在风险，请更换"),
    NOT_EXIST("库中无库存，请到户籍所在地进行核实");

	private String desc;

	RealNameIdentifyResult(String desc)
	{
		this.desc = desc;
	}

	public String getDesc()
	{
		return desc;
	}

	public static void main(String[] args) {

	}
}
