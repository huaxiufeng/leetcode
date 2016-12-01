class Solution
{
    public:
        vector <int> getRow(int rowIndex)
        {
            vector <int> result;
            int k = 0;
            do
            {
                result.push_back(comb(rowIndex, k));
                k++;
            }
            while (k <= rowIndex);

            return result;
        }
    private:
        int comb(int n, int m)
        {
            int ret = 1;

            if (m > n / 2) {
                m = n - m;
            }
            int fz = 1;

            for (int i = 1; i <= m; i++) {
                int fm = (n - m + i);

                fz = fz * i;
                for (int j = 2; j <= fz; j++) {
                    if (fm % j == 0 && fz % j == 0) {
                        fm = fm / j;
                        fz = fz / j;
                    }
                    if (ret % j == 0 && fz % j == 0) {
                        ret = ret / j;
                        fz = fz / j;
                    }
                }
                if (ret % fz == 0) {
                    ret = ret / fz;
                    fz = 1;
                }
                if (fm % fz == 0) {
                    fm = fm / fz;
                    fz = 1;
                }
                ret = ret * fm;
            }
            return ret / fz;
        }
};
