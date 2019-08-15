package com.jzhl.kfsq.service.mm;

import java.util.List;

import com.jzhl.kfsq.dataset.mm.AchievementDataSet;

public interface IAchievementService {

	public List<AchievementDataSet> findAchievement(int test_id);

}
