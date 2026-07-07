class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int []indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []p:prerequisites)
        {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }

        int course=0;

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            course++;

            for(int neighbor:adj.get(curr))
            {
                indegree[neighbor]--;

                if(indegree[neighbor]==0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return course==numCourses;
        
    }
}
