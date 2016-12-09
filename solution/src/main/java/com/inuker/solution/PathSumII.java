package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/29.
 */

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }

        path.add(root.val);

        pathSum(root, sum, result, path);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            pathSum(root.left, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            pathSum(root.right, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}