package fastcampus.aos.part2.part2_chapter11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import fastcampus.aos.part2.part2_chapter11.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val homeData = context?.readData() ?: return
        binding.appBarTitleTextView.text = getString(R.string.appbar_title_text, homeData.user.nickname)
        binding.starCountView.text = getString(R.string.app_bar_start_count, homeData.user.starCount, homeData.user.totalCount)

        Glide.with(binding.appBarImageView).load(homeData.appbarImage).into(binding.appBarImageView)

        binding.appBarProgressBar.progress = homeData.user.starCount
        binding.appBarProgressBar.max = homeData.user.totalCount

    }

}