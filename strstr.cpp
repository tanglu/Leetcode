class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        if(haystack==NULL||needle==NULL) {
            return NULL;
        }
        int src_length = strlen(haystack);
        int dst_length = strlen(needle);
        int j = 0;
        if(dst_length>src_length) {
            return NULL;
        }
        for(int i=0;i<=src_length - dst_length;i++) {
            for(j=0;j<dst_length;j++) {
                if(haystack[i+j]!=needle[j]) {
                    break;
                }
            }
            if(j==dst_length) {
                return haystack + i;
            }
        }
        return NULL;
    }
};
