package com.jzhl.kfsq.dataset.bm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jzhl.kfsq.dataset.cm.BuildingCommentV3DataSet;

/**
 * 楼盘详情结果集
 * 
 * @author Shaw
 *
 */
public class BuildingDetail implements Serializable {

	private static final long serialVersionUID = -9152436953383801474L;// 序列化

	private Integer buildingId;// 楼盘编号

	private String buildingName;// 楼盘名称

	private String averagePrice;// 均价

	private String address;// 地址

	private String phone;// 电话

	private String banner;// 楼盘大图

	private String totalScore;// 总评分

	private String countMember;// 参与人数

	private List<BuildingTagDataSet> highOpinions = new ArrayList<BuildingTagDataSet>();// 好评标签集合

	private List<BuildingTagDataSet> negativeComments = new ArrayList<BuildingTagDataSet>();// 差评标签集合

	private UnitMapV3DataSet unitMap = new UnitMapV3DataSet();// 户型结果集

	private CommunityQualityV3DataSet communityQuality = new CommunityQualityV3DataSet();// 社区品质结果集

	private EducationDataSet education = new EducationDataSet();// 教育结果集

	private AroundV2DataSet around = new AroundV2DataSet();// 周边配套结果集

	private TrafficV3DataSet traffic = new TrafficV3DataSet();// 交通结果集

	private String countHighOpinion;// 好评数量

	private String countNegativeComment;// 差评数量

	private String countUnitMap;// 户型评论数量

	private String countCommunityQuality;// 社区品质评论数量

	private String countTraffic;// 交通评论数量

	private String countEducation;// 教育评论数量

	private String countAround;// 周边配套数量

	private BuildingCommentV3DataSet comment;// 最近一条评论

	private List<RecommendBuildingsV3DataSet> areas = new ArrayList<RecommendBuildingsV3DataSet>();// 同地段楼盘集合,显示2条

	private List<RecommendBuildingsV3DataSet> prices = new ArrayList<RecommendBuildingsV3DataSet>();// 同价位楼盘集合,显示2条

	private List<RecommendBuildingsV3DataSet> tags = new ArrayList<RecommendBuildingsV3DataSet>();// 同特色楼盘集合,显示2条

	private boolean hasLook = false;// 是否已看房

	private boolean hasJoinPlan = false;// 是否已加入计划

	private boolean hasEnvelope = false;// 是否有红包

	private Integer salesType; // 销售状态

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBanner() {
		if (banner == null || "".equals(banner)) {
			return "";
		}
		return banner;
	}

	public String getSmallBanner() {
		if (banner == null || "".equals(banner)) {
			return "";
		}
		String imageName = banner.substring(0, banner.lastIndexOf("."));
		String extName = banner.substring(banner.lastIndexOf(".") + 1);
		return imageName + "_small." + extName;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getCountMember() {
		return countMember;
	}

	public void setCountMember(String countMember) {
		this.countMember = countMember;
	}

	public List<BuildingTagDataSet> getHighOpinions() {
		return highOpinions;
	}

	public void setHighOpinions(List<BuildingTagDataSet> highOpinions) {
		this.highOpinions = highOpinions;
	}

	public List<BuildingTagDataSet> getNegativeComments() {
		return negativeComments;
	}

	public void setNegativeComments(List<BuildingTagDataSet> negativeComments) {
		this.negativeComments = negativeComments;
	}

	public UnitMapV3DataSet getUnitMap() {
		return unitMap;
	}

	public void setUnitMap(UnitMapV3DataSet unitMap) {
		this.unitMap = unitMap;
	}

	public CommunityQualityV3DataSet getCommunityQuality() {
		return communityQuality;
	}

	public void setCommunityQuality(CommunityQualityV3DataSet communityQuality) {
		this.communityQuality = communityQuality;
	}

	public EducationDataSet getEducation() {
		return education;
	}

	public void setEducation(EducationDataSet education) {
		this.education = education;
	}

	public AroundV2DataSet getAround() {
		return around;
	}

	public void setAround(AroundV2DataSet around) {
		this.around = around;
	}

	public TrafficV3DataSet getTraffic() {
		return traffic;
	}

	public void setTraffic(TrafficV3DataSet traffic) {
		this.traffic = traffic;
	}

	public String getCountHighOpinion() {
		return countHighOpinion;
	}

	public void setCountHighOpinion(String countHighOpinion) {
		this.countHighOpinion = countHighOpinion;
	}

	public String getCountNegativeComment() {
		return countNegativeComment;
	}

	public void setCountNegativeComment(String countNegativeComment) {
		this.countNegativeComment = countNegativeComment;
	}

	public String getCountUnitMap() {
		return countUnitMap;
	}

	public void setCountUnitMap(String countUnitMap) {
		this.countUnitMap = countUnitMap;
	}

	public String getCountCommunityQuality() {
		return countCommunityQuality;
	}

	public void setCountCommunityQuality(String countCommunityQuality) {
		this.countCommunityQuality = countCommunityQuality;
	}

	public String getCountTraffic() {
		return countTraffic;
	}

	public void setCountTraffic(String countTraffic) {
		this.countTraffic = countTraffic;
	}

	public String getCountEducation() {
		return countEducation;
	}

	public void setCountEducation(String countEducation) {
		this.countEducation = countEducation;
	}

	public String getCountAround() {
		return countAround;
	}

	public void setCountAround(String countAround) {
		this.countAround = countAround;
	}

	public BuildingCommentV3DataSet getComment() {
		return comment;
	}

	public void setComment(BuildingCommentV3DataSet comment) {
		this.comment = comment;
	}

	public List<RecommendBuildingsV3DataSet> getAreas() {
		return areas;
	}

	public void setAreas(List<RecommendBuildingsV3DataSet> areas) {
		this.areas = areas;
	}

	public List<RecommendBuildingsV3DataSet> getPrices() {
		return prices;
	}

	public void setPrices(List<RecommendBuildingsV3DataSet> prices) {
		this.prices = prices;
	}

	public List<RecommendBuildingsV3DataSet> getTags() {
		return tags;
	}

	public void setTags(List<RecommendBuildingsV3DataSet> tags) {
		this.tags = tags;
	}

	public boolean isHasLook() {
		return hasLook;
	}

	public void setHasLook(boolean hasLook) {
		this.hasLook = hasLook;
	}

	public boolean isHasJoinPlan() {
		return hasJoinPlan;
	}

	public void setHasJoinPlan(boolean hasJoinPlan) {
		this.hasJoinPlan = hasJoinPlan;
	}

	public boolean isHasEnvelope() {
		return hasEnvelope;
	}

	public void setHasEnvelope(boolean hasEnvelope) {
		this.hasEnvelope = hasEnvelope;
	}

	public Integer getSalesType() {
		return salesType;
	}

	public void setSalesType(Integer salesType) {
		this.salesType = salesType;
	}

}
